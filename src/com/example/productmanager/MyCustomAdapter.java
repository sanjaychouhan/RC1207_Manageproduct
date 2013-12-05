package com.example.productmanager;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MyCustomAdapter extends ArrayAdapter <Product> {

	Context context;
	List<Product> list;
	
	public MyCustomAdapter(Context context, int textViewResourceId, List<Product> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		this.list = objects;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater =
		(LayoutInflater) context.getSystemService
		(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.detail, parent, false);
		
		TextView id = (TextView) view.findViewById(R.id.pidvalue);
		TextView name = (TextView) view.findViewById(R.id.pnamevalue);
		TextView price = (TextView) view.findViewById(R.id.ppricevalue);
		Button button=(Button) view.findViewById(R.id.updatebtn);
		Button delete=(Button) view.findViewById(R.id.delete);
		
		Product product = list.get(position);
		delete.setTag(product.getProductId());
		button.setTag(product.getProductId());
		id.setText(String.valueOf(product.getProductId()));
		name.setText(product.getProductName());
		price.setText(String.valueOf(product.getProductPrice()));
		
		return view;
	}

}








