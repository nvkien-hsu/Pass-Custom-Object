package com.example.passobject;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class OtherActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ArrayList<ObjectA> dataList = new ArrayList<ObjectA>();
		Intent intent = getIntent();
		dataList = intent.getParcelableArrayListExtra("custom_data_list");
		Toast.makeText(getApplicationContext(), dataList.get(0).getStrValue(), Toast.LENGTH_LONG).show();
		//Log.v("Tag", "My Present is: " + myPresent.getText());
	}
}
