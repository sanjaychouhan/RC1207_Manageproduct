package com.example.productmanager;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ProductDataSource {
	
	private MySQLiteHelper helper;
	private SQLiteDatabase database;
	
	public ProductDataSource(Context context) {
		super();
		helper = new MySQLiteHelper(context);
	}
	
	public void open() throws SQLException{
		database = helper.getWritableDatabase();
	}
	
	public void close(){
		database.close();
	}
	
	public void addProductDetail(Product product){
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_PRODUCT_ID, 
				product.getProductId());
		values.put(MySQLiteHelper.COLUMN_PRODUCT_NAME, 
				product.getProductName());
		values.put(MySQLiteHelper.COLUMN_PRODUCT_PRICE, 
				product.getProductPrice());
		database.insert(MySQLiteHelper.TABLE_NAME, null, values);
	}
	
	public List<Product> getAllProduct(){
		Cursor cursor =
		database.rawQuery("select * from " 
		+ MySQLiteHelper.TABLE_NAME, null);
		Product product;
		List<Product> pList = new ArrayList<Product>();
		if(cursor.getCount() != 0){
			if(cursor.moveToFirst()){
				do{
					product = new Product();
					product.setProductId(cursor.getInt(0));
					product.setProductName(cursor.getString(1));
					product.setProductPrice(cursor.getInt(2));
					pList.add(product);
				}while(cursor.moveToNext());
			}
		}
		return pList;
		
	}
	public Product getProductDetail(int id){
		Cursor cursor=database.rawQuery("select * from " + MySQLiteHelper.TABLE_NAME + " where " + MySQLiteHelper.COLUMN_PRODUCT_ID + "=" + id, null);
		Product product=null;
		if(cursor.getCount() !=0){
			if(cursor.moveToFirst()){
				product=new Product();
				product.setProductName(cursor.getString(1));
				product.setProductPrice(cursor.getInt(2));
				
				
			}
			
		}return product;
		
	}
	public void updateProduct(Product product){
	ContentValues values=new ContentValues();
	values.put(MySQLiteHelper.COLUMN_PRODUCT_NAME, product.getProductName());
	values.put(MySQLiteHelper.COLUMN_PRODUCT_PRICE, product.getProductPrice());
	database.update(MySQLiteHelper.TABLE_NAME, values,MySQLiteHelper.COLUMN_PRODUCT_ID + "=" + product.getProductId(),null);
	}
	public void deleteProductdetail(int pid){
		database.delete(MySQLiteHelper.TABLE_NAME, MySQLiteHelper.COLUMN_PRODUCT_ID + "=" +pid,null);
	}
	}
	







