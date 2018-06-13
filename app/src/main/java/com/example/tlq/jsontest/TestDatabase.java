package com.example.tlq.jsontest;

import android.content.Context;

/**
 * Created by Hell on 2017/9/11.
 */
public class TestDatabase {
	private static final String TAG = "TestDatabase";
	private TestDatabaseHelper testDatabaseHelper;
	private static final Object mLock = new Object();
	private static EInkDatabase mInstance;

	public static TestDatabase getInstance(Context context) {
		synchronized (mLock) {
			if (mInstance == null) {
				mInstance = new EInkDatabase(context.getApplicationContext());
			}
			return mInstance;
		}
	}

    private TestDatabase(Context context){
		testDatabaseHelper = new TestDatabaseHelper(context);
	}

//	/**
//	 *插入一条NoteInfo
//	 * @param goodsInfo
//	 */
//	public synchronized void insertNoteInfo(GoodsInfo goodsInfo) {
//		SQLiteDatabase db = testDatabaseHelper.getWritableDatabase();
//		db.beginTransaction();//开启事务
//		try{
//			ContentValues values = new ContentValues();
//			values.put("buyCount", goodsInfo.getBuyCount());
//			values.put("collectCount", goodsInfo.getCollectCount());
//			values.put("contentId", goodsInfo.getContentId());
//			values.put("contentInfo", goodsInfo.getContentInfo().toString());
//			values.put("contentType", goodsInfo.getContentType());
//			values.put("createrId", goodsInfo.getCreaterId());
//			values.put("createrName", goodsInfo.getCreaterName());
//			values.put("createrType", goodsInfo.getCreaterName());
//			values.put("goodsId", goodsInfo.getGoodsId());
//			values.put("intro", goodsInfo.getIntro());
//			values.put("name", goodsInfo.getName());
//			values.put("oerResourceId", goodsInfo.getOerResourceId());
//			values.put("previewResourceId", goodsInfo.getPreviewResourceId());
//			values.put("price", goodsInfo.getPrice());
//			values.put("resources", goodsInfo.getResources().toString());
//			values.put("viewCount", goodsInfo.getViewCount());
//
//			db.insert(Constants.DB.DOWNLOAD_GOODS_INFO_TABLE, null, values);
//			db.setTransactionSuccessful();//设置事务状态成功才会提交
//
//		} catch(Exception e){
//			Log.d(TAG,e.toString());
//
//		} finally{
//			//结束事务
//			db.endTransaction();//结束事务
//		}
//		db.close();
//	}




}
