package com.example.productmanager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewProduct extends Activity{

	List<Product> list;
	ListView listView;
	TextView textView;
	MyCustomAdapter adapter;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewproductdetail);
		
		list = new ArrayList<Product>();
		listView = (ListView) findViewById(R.id.productlist);
		textView = (TextView) findViewById(R.id.totalproduct);
		ProductDataSource dataSource = new ProductDataSource(this);
		dataSource.open();
		list = dataSource.getAllProduct();
		dataSource.close();
		int count = list.size();
		textView.setText("Total Product: " + String.valueOf(count));
		 adapter = new MyCustomAdapter(this, R.layout.detail, list);
		listView.setAdapter(adapter);
	}
	public void updateProduct(View view){
		String id=String.valueOf(view.getTag());
		Intent intent=new Intent(this,UpdateProduct.class);
		intent.putExtra("productid", id);
		startActivity(intent);
		
		
		
	}
	public  void deleteProduct(View view){
		String id=String.valueOf(view.getTag());
		 final int pid=Integer.parseInt(id);
		AlertDialog alert=null;
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("Confirmation message");
		builder.setMessage("are you sure you want to delete");
		builder.setPositiveButton("yes",new OnClickListener(){

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				ProductDataSource dataSource=new ProductDataSource(getBaseContext());
				dataSource.open();
				dataSource.deleteProductdetail(pid);
				dataSource.close();
				adapter.notifyDataSetChanged();
				Toast.makeText(getBaseContext()," Deleted", Toast.LENGTH_LONG).show();
				
				
				
				
			}
			
		});
		builder.setNegativeButton("No", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
		});
	
	alert=builder.create();
	alert.show();
	
	
	
	
}}










