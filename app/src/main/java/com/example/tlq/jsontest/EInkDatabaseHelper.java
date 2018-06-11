package com.example.tlq.jsontest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;


/**
 * Created by Hell on 2017/9/11.
 */
public class EInkDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "EInkDatabaseHelper";

    /**
     * 创建图片信息表
     */
    private String CREATE_NOTE_INFO_TABLE = String.format("create table if not exists %s ("
            + "%s integer primary key autoincrement,"
            + "%s text," + "%s text," + "%s text," + "%s text," + "%s text)",
            Constants.DB.NOTE_INFO_TABLE,
            "id", "noteId", "noteDate", "noteTime", "noteTitle", "noteImage");

    private String CREATE_TEMP_ANSWER_INFO_TABLE = String.format("create table if not exists %s ("
            + "%s integer primary key autoincrement," + "%s text," + "%s text," + "%s text," + "%s text)",
            Constants.DB.TEMP_ANSWER_INFO_TABLE,
            "id", "questionId", "packageId", "studentId", "answerInfo");

    private String CREATE_TEMP_REQUEST_INFO_TABLE = String.format("create table if not exists %s ("
            + "%s integer primary key autoincrement," + "%s text," + "%s text," + "%s text)",
            Constants.DB.TEMP_REQUEST_INFO_TABLE, "id", "type", "requestAddress", "webAddress");


    /** 创建商品信息结构表(GoodsInfo)*/
    private String CREATE_DOWNLOAD_GOODS_INFO_TABLE = String.format("create table if not exists %s ("
                    + "%s integer primary key autoincrement,"
                    + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text," + "%s text," + "%s text)",
            Constants.DB.DOWNLOAD_GOODS_INFO_TABLE,
            "id", "goodsId", "resources", "previewResourceID", "name", "intro", "price", "contentType",
            "contentId", "createrId", "createrType", "createrName", "createTime", "viewCount",
            "buyCount", "collectCount", "ContentInfo");


    /**创建文件资源结构表(SourceFile) */
    private String CREATE_SOURCE_FILE_TABLE = String.format("create table if not exists %s ("
                    + "%s integer primary key autoincrement,"
                    + "%s text," + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text,"+ "%s text," + "%s text," + "%s text," + "%s text)",
            Constants.DB.SOURCE_FILE_TABLE,
            "id","goodsId", "resourceID", "resourceType", "resourceName", "metaID",
            "postfix", "size", "md5sum", "mimetype", "localpath");


    /*** 教辅章节信息(TeachingPkgBookChapterInfo)*/
    private String CREATE_TEACHING_PKG_BOOK_CHAPTER_INFO_TABLE = String.format(
            "create table if not exists %s ( %s integer primary key autoincrement,"
                    + "%s text," + "%s text," + "%s text," + "%s text," + "%s text)",
            Constants.DB.TEACHING_PKG_BOOK_CHAPTER_INFO_TABLE,
            "id","goodsId",  "pkgChapterId", "pkgChapterName", "pkgBookId", "questionList");


    /**
     * 创建教辅信息(TeachingPkgBookInfo)
     */
    private String CREATE_TEACHING_PKG_BOOK_INFO_TABLE = String.format("create table if not exists %s ("
                    + "%s integer primary key autoincrement,"
                    + "%s text,"  + "%s text,"+ "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text)",
            Constants.DB.TEACHING_PKG_BOOK_INFO_TABLE,
            "id", "goodsId","pkgBookId", "name", "intro", "author", "subjectId", "subject", "gradeId",
            "grade", "publishingId", "publishing", "chapterList");


    /**
     * 创建套题信息(TeachingPkgInfo)
     */
    private String CREATE_TEACHING_PKG_INFO_TABLE = String.format("create table if not exists %s ("
                    + "%s integer primary key autoincrement,"
                    + "%s text," + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text)",
            Constants.DB.TEACHING_PKG_INFO_TABLE,
            "id","goodsId", "pkgId", "name", "intro", "subjectId", "subject", "gradeId",
            "grade", "schoolbookId", "schoolbookName", "volumeId", "volumeName",
            "unitId", "unitName", "chapterId", "chapterName", "sectionId", "sectionName",
            "publishingId", "publishing", "adviseDuration", "difficulty", "questioList");


    /**
     * 创建习题基础数据结构表(QuestionInfo)
     */
    private String CREATE_QUESTION_INFO_TABLE = String.format("create table if not exists %s ("
                    + "%s integer primary key autoincrement,"
                    + "%s text," + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text,"+ "%s text)",
            Constants.DB.QUESTION_INFO_TABLE,
            "id","goodsId", "questionId", "questionTitle", "subjectId", "SubjectName",
            "questionType", "questionInfo");


    /**
     * 创建资源信息(TeachingResourceInfo)
     */

    private String CREATE_TEACHING_RESOURCE_INFO_TABLE = String.format("create table if not exists %s ("
                    + "%s integer primary key autoincrement,"
                    + "%s text,"+ "%s text," + "%s Integer," + "%s text," + "%s text,"
                    + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text," + "%s text," + "%s text,"
                    + "%s text," + "%s text," + "%s text," + "%s text)",
            Constants.DB.TEACHING_RESOURCE_INFO_TABLE,
            "id","goodsId", "resourceInfo", "resId", "name", "intro", "subjectId", "subject",
            "gradeId", "grade", "schoolbookId", "schoolbookName", "volumeId",
            "volumeName", "unitId", "unitName", "chapterId", "chapterName", "sectionId",
            "sectionName", "publishingId", "publishing");


    /**
     * 创建数据库
     *
     * @param context
     */
    public EInkDatabaseHelper(Context context) {
        super(context, Constants.DB.DB_NAME, null, Constants.DB.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NOTE_INFO_TABLE);
        db.execSQL(CREATE_TEMP_ANSWER_INFO_TABLE);
        db.execSQL(CREATE_TEMP_REQUEST_INFO_TABLE);

        db.execSQL(CREATE_DOWNLOAD_GOODS_INFO_TABLE);
        db.execSQL(CREATE_SOURCE_FILE_TABLE);
        db.execSQL(CREATE_TEACHING_PKG_BOOK_CHAPTER_INFO_TABLE);
        db.execSQL(CREATE_TEACHING_PKG_BOOK_INFO_TABLE);
        db.execSQL(CREATE_TEACHING_PKG_INFO_TABLE);
        db.execSQL(CREATE_QUESTION_INFO_TABLE);
        db.execSQL(CREATE_TEACHING_RESOURCE_INFO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    /**
     * 判断某张表是否存在
     * @param tabName 表名
     * @return
     */
    public boolean tableIsExist(String tabName){
        boolean result = false;
        if(TextUtils.isEmpty(tabName)){
            return false;
        }
        try {
            SQLiteDatabase db = this.getReadableDatabase();//此this是继承SQLiteOpenHelper类得到的
            String sql = "select count(*) as c from sqlite_master where type ='table' and name ='"+tabName.trim()+"' ";
            Cursor cursor = db.rawQuery(sql, null);
            if(cursor.moveToNext()){
                int count = cursor.getInt(0);
                if(count > 0){
                    result = true;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

}
