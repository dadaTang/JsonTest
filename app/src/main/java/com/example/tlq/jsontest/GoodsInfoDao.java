package com.example.tlq.jsontest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tlq.jsontest.oer.GoodsInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Create By tlq
 * 2018-6-6
 * */
public class GoodsInfoDao {
    public static final String TAG = "GoodsInfoDao";
    //初始化Goods路径
    private String mGoodsPath;

    private GoodsInfo goodsInfo;

    private Context context;

    private SQLiteDatabase db;

    boolean mSdCardExist;



    public GoodsInfoDao(Context context) {
        this.context = context;
    }

    public void addObjectToList() {

        mSdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        Gson gson;
        //判断数据文件是否存在
        if (mSdCardExist) {


            mGoodsPath = Environment.getExternalStorageDirectory().toString() + "/test/META-INFO";
            File dataInfo = new File(mGoodsPath + "/DataInfo.json");
            if (dataInfo.exists()) {
                //获取SD卡文件内容字符串
                String tmpStr = FileUtil.readFileFromSDCard(dataInfo);
                try {
                    gson = new Gson();

                    goodsInfo = gson.fromJson(tmpStr, new TypeToken<GoodsInfo>(){}.getType());
                    insertModelToDb(goodsInfo);

                } catch (Exception e) {
                    Log.e(TAG, "错误：" + e.getMessage());
                }
            }
        } else {
            Toast.makeText(MyApplication.getContext(), "请插入SD卡！", Toast.LENGTH_SHORT).show();
        }

    }

    //插入数据到数据库
    public void insertModelToDb(GoodsInfo goodsInfo) {

        //获取helper对象
        TestDatabaseHelper testDatabaseHelper = new TestDatabaseHelper(context);
        //获取数据库操作对象(写)
        db = testDatabaseHelper.getWritableDatabase();
        //开始事务
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put("buyCount", goodsInfo.getBuyCount());
            contentValues.put("collectCount", goodsInfo.getCollectCount());
            contentValues.put("contentType",goodsInfo.getContentType().toString());
            contentValues.put("contentId", goodsInfo.getContentId());
            contentValues.put("contentInfo", goodsInfo.getGoodsId());
            contentValues.put("contentType", goodsInfo.getContentType());
            contentValues.put("createrId", goodsInfo.getCreaterId());
            contentValues.put("createrName", goodsInfo.getCreaterName());
            contentValues.put("createrType", goodsInfo.getCreaterType());
            contentValues.put("goodsId", goodsInfo.getGoodsId());
            contentValues.put("intro", goodsInfo.getIntro());
            contentValues.put("name", goodsInfo.getName());
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


}
