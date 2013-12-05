package com.example.productmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateProduct extends Activity {
	EditText name,price;
	int id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.updateproduct);
		name=(EditText) findViewById(R.id.updatedname);
		price=(EditText) findViewById(R.id.updatedprice);
		
		Bundle bundle=getIntent().getExtras();
	 id=Integer.parseInt(bundle.getString("productid"));
	ProductDataSource dataSource=new ProductDataSource(this);
	dataSource.open();
	Product product=dataSource.getProductDetail(id);
	dataSource.close();
	name.setText(product.getProductName());
	price.setText(String.valueOf(product.getProductPrice()));
	
	}
	public void updateProductDetail(View view){
		String name=this.name.getText().toString();
		int price=Integer.parseInt(this.price.getText().toString().trim());
		Product product=new Product(id,name,price);
		ProductDataSource dataSource=new ProductDataSource(this);
		dataSource.open();
		dataSource.updateProduct(product);
		dataSource.close();
		Toast.makeText(this, "Product data updated successfully", Toast.LENGTH_LONG).show();
		
	}

}
