package com.example.tlq.jsontest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.example.tlq.jsontest.oer.ChapterList;
import com.example.tlq.jsontest.oer.GoodsInfo;
import com.example.tlq.jsontest.oer.QuestionList;
import com.example.tlq.jsontest.oer.SourceFile;
import com.example.tlq.jsontest.oer.TeachingPkgBookInfo;
import com.example.tlq.jsontest.oer.TeachingPkgInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.List;
import java.util.Map;


/**
 * Create By tlq
 * 2018-6-6
 *
 * 需要在下载后调用
 */
public class GoodsInfoDao {
    public static final String TAG = "GoodsInfoDao";
    //初始化Goods路径
    private String mGoodsPath;
    //初始化商品信息结构
    private GoodsInfo goodsInfo;
    //商品编号
    private Integer mGoodsId;
    private EInkDatabaseHelper eInkDatabaseHelper;
    //初始化数据库
    private SQLiteDatabase db;
    //SD卡判断
    private boolean mSdCardExist;
    //获取gson对象
    private Gson mGson;

    private static GoodsInfoDao mInstance;
    private static final Object mLock = new Object();

    //获取单例
    public static GoodsInfoDao getInstance(Context context) {
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new GoodsInfoDao(context.getApplicationContext());
            }
            return mInstance;
        }
    }

    public GoodsInfoDao(Context context) {
        eInkDatabaseHelper = new EInkDatabaseHelper(context);
    }


    /**
     * 开始解析
     */
    public void addObjectToDb() {
        //获取sd状态
        mSdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);

        //判断数据文件是否存在
        if (mSdCardExist) {
            /**
             * 需要对下载文件的区分和清理
             * */
            //获取下载路径
            mGoodsPath = Constants.FILE_ROOT_FOLDER + "/stemEink/META-INFO";
            //获取下载文件
            File dataInfo = new File(mGoodsPath + "/DataInfo.json");
            //判断文件是否存在
            if (dataInfo.exists()) {
                //获取SD卡文件内容字符串
                String tmpStr = FileUtil.readFileFromSDCard(dataInfo);
                try {
                    //初始化gson对象
                    mGson = new Gson();
                    goodsInfo = mGson.fromJson(tmpStr, new TypeToken<GoodsInfo>() {
                    }.getType());
                    mGoodsId = goodsInfo.getGoodsId();
                    //判断数据库是否有相同的goodsID号
                    if (!existGoodsId(mGoodsId)) {
                        insertGoodsInfoToDb(goodsInfo);
                        //判断contenttype类型来区分商品种类(1,TeachingPkgInfo;2,BookInfo;3,TeachingPkgBookInfo)
                        if (1 == goodsInfo.getContentType()) {
                            //获取商品内容
                            String tempJson = mGson.toJson(goodsInfo.getContentInfo());
                            //商品好作为标识
                            insertTeachingPkgInfoToDb(tempJson);
                            // PkgID唯一
                        } else if (2 == goodsInfo.getContentType()) {
                            //暂时还不用的

                        } else if (3 == goodsInfo.getContentType()) {
                            //获取商品内容
                            String tempJson = mGson.toJson(goodsInfo.getContentInfo());
                            //商品好作为标识
                            insertTeachingPkgBookInfoToDb(tempJson);
                        }
                        //解析获取Resources对象值,循环插入
                        Map<String, SourceFile> sourece = goodsInfo.getResources();
                        String tempjson;
                        for (String string : sourece.keySet()) {
                            tempjson = mGson.toJson(sourece.get(string));
                            insertResourcesToDb(tempjson);
                        }
                    } else {
                        Toast.makeText(MyApplication.getContext(), "请勿重复购买！", Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    Log.e(TAG, "错误：" + e.getMessage());
                }
            } else {
                Toast.makeText(MyApplication.getContext(), "资源文件不全,请重新下载或联系管理员！", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MyApplication.getContext(), "请插入SD卡！", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 插入goodsInfo数据到数据库
     */
    private synchronized void insertGoodsInfoToDb(GoodsInfo goodsInfo) {
        //获取数据库操作对象(写)
        db = eInkDatabaseHelper.getWritableDatabase();
        //开始事务
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("buyCount", goodsInfo.getBuyCount());
            contentValues.put("collectCount", goodsInfo.getCollectCount());
            contentValues.put("contentId", goodsInfo.getContentId());
            contentValues.put("contentInfo", goodsInfo.getGoodsId());
            contentValues.put("contentType", goodsInfo.getContentType());
            contentValues.put("createrId", goodsInfo.getCreaterId());
            //应以获取下载时间为准
            String createTime = System.currentTimeMillis() + "";
            contentValues.put("createTime", createTime);
            contentValues.put("createrName", goodsInfo.getCreaterName());
            contentValues.put("createrType", goodsInfo.getCreaterType());
            contentValues.put("goodsId", goodsInfo.getGoodsId());
            contentValues.put("intro", goodsInfo.getIntro());
            contentValues.put("name", goodsInfo.getName());
            contentValues.put("oerResourceId", goodsInfo.getOerResourceId());
            contentValues.put("previewResourceId", goodsInfo.getPreviewResourceId());
            contentValues.put("price", goodsInfo.getPrice());
            contentValues.put("resources", goodsInfo.getGoodsId());
            contentValues.put("viewCount", goodsInfo.getViewCount());
            db.insert(Constants.DB.DOWNLOAD_GOODS_INFO_TABLE, null, contentValues);
            db.setTransactionSuccessful();//设置事务状态成功才会提交
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //提交
            db.endTransaction();
            db.close();
        }
    }

    /**
     * 查询数据库关键字,用于判断是否存在相同的goods
     * false:不存在
     * ture:存在
     */
    public synchronized boolean existGoodsId(Integer goodsId) {
        boolean flag = false;
        db = eInkDatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query(Constants.DB.DOWNLOAD_GOODS_INFO_TABLE, new String[]{"goodsId"},
                "goodsId=?", new String[]{goodsId.toString()},
                null, null, null);
        if (cursor.moveToNext()) {
            flag = true;
        }
        cursor.close();
        return flag;
    }

    /**
     * 插入TeachingPkgInfo数据到数据库
     */
    public synchronized void insertTeachingPkgInfoToDb(String ContentInfoJson) {
        mGson = new Gson();
        //解析json对象
        TeachingPkgInfo teachingPkgInfo = mGson.fromJson(ContentInfoJson, TeachingPkgInfo.class);
        //TeachingPkgInfo teachingPkgInfo = new Gson().fromJson(json, new TypeToken<TeachingPkgInfo>() {
        // }.getType());
        //获取数据库操作对象(写)
        db = eInkDatabaseHelper.getWritableDatabase();
        //开始事务
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pkgId", teachingPkgInfo.getPkgId());
            contentValues.put("name", teachingPkgInfo.getName());
            contentValues.put("subjectId", teachingPkgInfo.getSubjectId());
            contentValues.put("subject", teachingPkgInfo.getSubject());
            contentValues.put("gradeId", teachingPkgInfo.getGradeId());
            contentValues.put("grade", teachingPkgInfo.getGrade());
            contentValues.put("schoolbookId", teachingPkgInfo.getSchoolbookId());
            contentValues.put("schoolbookName", teachingPkgInfo.getSchoolbookName());
            contentValues.put("volumeId", teachingPkgInfo.getVolumeId());
            contentValues.put("volumeName", teachingPkgInfo.getVolumeName());
            contentValues.put("unitId", teachingPkgInfo.getUnitId());
            contentValues.put("unitName", teachingPkgInfo.getUnitName());
            contentValues.put("chapterId", teachingPkgInfo.getChapterId());
            contentValues.put("chapterName", teachingPkgInfo.getChapterName());
            contentValues.put("sectionId", teachingPkgInfo.getSectionId());
            contentValues.put("sectionName", teachingPkgInfo.getSectionName());
            contentValues.put("publishingId", teachingPkgInfo.getPublishingId());
            contentValues.put("publishing", teachingPkgInfo.getPublishing());
            contentValues.put("adviseDuration", teachingPkgInfo.getAdviseDuration());
            contentValues.put("difficulty", teachingPkgInfo.getDifficulty());
            //获取questionID
            contentValues.put("questionList", teachingPkgInfo.getPkgId());
            contentValues.put("goodsId", mGoodsId);
            db.insert(Constants.DB.TEACHING_PKG_INFO_TABLE, null, contentValues);
            db.setTransactionSuccessful();//设置事务状态成功才会提交
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //提交
            db.endTransaction();
            db.close();
        }
        //获取QuestionList
        List<QuestionList> lists = teachingPkgInfo.getQuestionList();
        String tempjson;
        //循环添加
        for (int i = 0; i < lists.size(); i++) {
            tempjson = mGson.toJson(lists.get(i));
            insertQuestionListToDb(tempjson);
        }
    }

    /**
     * 插入TeachingPkgBookInfo数据到数据库
     */
    public synchronized void insertTeachingPkgBookInfoToDb(String json) {
        mGson = new Gson();
        //解析json对象
        TeachingPkgBookInfo teachingPkgBookInfo = mGson.fromJson(json, TeachingPkgBookInfo.class);
        //获取数据库操作对象(写)
        db = eInkDatabaseHelper.getWritableDatabase();
        //开始事务
        db.beginTransaction();
        try {
            //修改下列的value的key值
            ContentValues contentValues = new ContentValues();
            contentValues.put("pkgBookId", teachingPkgBookInfo.getPkgBookId());
            contentValues.put("name", teachingPkgBookInfo.getName());
            contentValues.put("intro", teachingPkgBookInfo.getIntro());
            contentValues.put("author", teachingPkgBookInfo.getAuthor());
            contentValues.put("subjectId", teachingPkgBookInfo.getSubjectId());
            contentValues.put("subject", teachingPkgBookInfo.getSubject());
            contentValues.put("gradeId", teachingPkgBookInfo.getGradeId());
            contentValues.put("grade", teachingPkgBookInfo.getGrade());
            contentValues.put("publishingId", teachingPkgBookInfo.getPublishingId());
            contentValues.put("publishing", teachingPkgBookInfo.getPublishing());
            contentValues.put("chapterList", teachingPkgBookInfo.getPkgBookId());
            contentValues.put("goodsId", mGoodsId);
            db.insert(Constants.DB.TEACHING_PKG_BOOK_INFO_TABLE, null, contentValues);
            db.setTransactionSuccessful();//设置事务状态成功才会提交
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //提交
            db.endTransaction();
            db.close();
        }
        //循环ChapterList
        List<ChapterList> lists = teachingPkgBookInfo.getChapterList();
        String tempjson;
        for (int i = 0; i < lists.size(); i++) {
            tempjson = mGson.toJson(lists.get(i));
            insertChapterListToDb(tempjson);
        }
    }

    /**
     * 插入ChapterList数据到数据库
     */
    public synchronized void insertChapterListToDb(String json) {
        mGson = new Gson();
        ChapterList chapterList = mGson.fromJson(json, ChapterList.class);
        db = eInkDatabaseHelper.getWritableDatabase();
        //开始事务
        db.beginTransaction();
        try {
            //修改下列的value的key值
            ContentValues contentValues = new ContentValues();
            contentValues.put("pkgChapterId", chapterList.getPkgChapterId());
            contentValues.put("pkgChapterName", chapterList.getPkgChapterName());
            contentValues.put("pkgBookId", chapterList.getPkgBookId());
            //存储唯一id来辨别
            contentValues.put("questionList", chapterList.getPkgChapterId());
            contentValues.put("goodsId", mGoodsId);
            db.insert(Constants.DB.TEACHING_PKG_BOOK_CHAPTER_INFO_TABLE, null, contentValues);
            db.setTransactionSuccessful();//设置事务状态成功才会提交
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //提交
            db.endTransaction();
            db.close();
        }
        //获取QuestionList
        List<QuestionList> lists = chapterList.getQuestionList();
        String tempjson;
        //循环插入questionInfo
        for (int i = 0; i < lists.size(); i++) {
            tempjson = mGson.toJson(lists.get(i));
            insertQuestionListToDb(tempjson);
        }


    }

    /**
     * 插入Resources数据到数据库
     */
    public synchronized void insertResourcesToDb(String json) {
        mGson = new Gson();
        SourceFile sourceFile = mGson.fromJson(json, new TypeToken<SourceFile>() {
        }.getType());

        //获取数据库操作对象(写)
        db = eInkDatabaseHelper.getWritableDatabase();
        //开始事务
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("resourceID", sourceFile.getResourceID());
            contentValues.put("resourceType", sourceFile.getResourceType());
            contentValues.put("resourceName", sourceFile.getResourceName());
            contentValues.put("metaID", sourceFile.getMetaID());
            contentValues.put("postfix", sourceFile.getPostfix());
            contentValues.put("size", sourceFile.getSize());
            contentValues.put("md5sum", sourceFile.getMd5sum());
            contentValues.put("mimetype", sourceFile.getMimetype());
            contentValues.put("localPath", sourceFile.getLocalPath());
            contentValues.put("goodsId", mGoodsId);
            db.insert(Constants.DB.SOURCE_FILE_TABLE, null, contentValues);
            db.setTransactionSuccessful();//设置事务状态成功才会提交
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //提交
            db.endTransaction();
            db.close();
        }
    }

    /**
     * 插入QuestionList数据到数据库
     */
    public synchronized void insertQuestionListToDb(String json) {
        mGson = new Gson();
        QuestionList questionList = mGson.fromJson(json, new TypeToken<QuestionList>() {
        }.getType());
        //获取questionInfo字符串
        String questionInfo = mGson.toJson(questionList.getQuestionInfo());
        //获取数据库操作对象(写)
        db = eInkDatabaseHelper.getWritableDatabase();
        //开始事务
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("questionId", questionList.getQuestionId());
            contentValues.put("questionInfo", questionInfo);
            contentValues.put("questionTitle", questionList.getQuestionTitle());
            contentValues.put("questionType", questionList.getQuestionType());
            contentValues.put("subjectId", questionList.getSubjectId());
            contentValues.put("subjectName", questionList.getSubjectName());
            contentValues.put("goodsId", mGoodsId);
            db.insert(Constants.DB.QUESTION_LIST_TABLE, null, contentValues);
            db.setTransactionSuccessful();//设置事务状态成功才会提交
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //提交
            db.endTransaction();
            db.close();
        }
    }
}
