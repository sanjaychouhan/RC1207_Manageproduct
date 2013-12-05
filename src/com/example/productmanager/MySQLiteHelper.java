
package com.example.productmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "PRODUCT_MANAGER";
	private static final int DATABASE_VERSION = 1;
	
	public static final String TABLE_NAME = "PRODUCT_DETAIL";
	public static final String COLUMN_PRODUCT_ID = "PRODUCT_ID";
	public static final String COLUMN_PRODUCT_NAME = "PRODUCT_NAME";
	public static final String COLUMN_PRODUCT_PRICE = "PRODUCT_PRICE";
	
	
	private static final String sql = 
			"create table "+TABLE_NAME+"("+COLUMN_PRODUCT_ID+" integer primary key" +
			","+COLUMN_PRODUCT_NAME+" text not null" +
			","+COLUMN_PRODUCT_PRICE+" integer not null)";
	
	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS " + MySQLiteHelper.TABLE_NAME);
		onCreate(database);
	}

}









