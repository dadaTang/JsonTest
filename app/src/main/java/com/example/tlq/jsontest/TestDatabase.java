package com.example.tlq.jsontest;

import android.content.Context;

/**
 * Created by Hell on 2017/9/11.
 */
public class TestDatabase {
	private static final String TAG = "TestDatabase";
	private TestDatabaseHelper testDatabaseHelper;
	private static final Object mLock = new Object();
	private static TestDatabase mInstance;

	public static TestDatabase getInstance(Context context) {
		synchronized (mLock) {
			if (mInstance == null) {
				mInstance = new TestDatabase(context.getApplicationContext());
			}
			return mInstance;
		}
	}

    private TestDatabase(Context context){
		testDatabaseHelper = new TestDatabaseHelper(context);
	}





}
