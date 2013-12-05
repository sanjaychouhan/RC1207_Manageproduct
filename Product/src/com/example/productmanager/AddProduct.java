package com.example.productmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduct extends Activity {

	EditText id, name, price;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addproduct);
		
		id = (EditText) findViewById(R.id.productid);
		name = (EditText) findViewById(R.id.productname);
		price = (EditText) findViewById(R.id.productprice);
	}
	
	public void saveProduct(View view){
		int id = Integer.parseInt(this.id.getText().toString());
		String name = this.name.getText().toString();
		int price = Integer.parseInt(this.price.getText().toString());
		
		Product product= new Product(id, name, price);
		ProductDataSource dataSource = new ProductDataSource(this);
		dataSource.open();
		dataSource.addProductDetail(product);
		dataSource.close();
		Toast.makeText(this, 
		"Product Added Successfully.", Toast.LENGTH_LONG).show();
		
		
	}
}







