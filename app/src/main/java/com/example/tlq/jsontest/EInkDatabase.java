package com.example.tlq.jsontest;

import android.content.Context;

/**
 * Created by Hell on 2017/9/11.
 */
public class EInkDatabase {
	private static final String TAG = "EInkDatabase";
	private EInkDatabaseHelper eInkDatabaseHelper;
	private static final Object mLock = new Object();
	private static EInkDatabase mInstance;

	public static EInkDatabase getInstance(Context context) {
		synchronized (mLock) {
			if (mInstance == null) {
				mInstance = new EInkDatabase(context.getApplicationContext());
			}
			return mInstance;
		}
	}

    private EInkDatabase(Context context){
		eInkDatabaseHelper = new EInkDatabaseHelper(context);
	}





}
