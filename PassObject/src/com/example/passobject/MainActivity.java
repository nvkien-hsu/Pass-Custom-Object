package com.example.passobject;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*SerializableObject textObject = new SerializableObject ("demo");
		Intent intent = new Intent(MainActivity.this, OtherActivity.class); // replace with own Activity class
		intent.putExtra("text", textObject);
		startActivity(intent);*/
		
		// Set values etc.
		ArrayList<ObjectA> dataList = new ArrayList<ObjectA>();
		ObjectA obj = new ObjectA();
		obj.setIntValue(1);
		obj.setStrValue("1 - from A object");
		dataList.add(obj);
		
		ObjectA obj1 = new ObjectA();
		obj1.setIntValue(2);
		obj1.setStrValue("2 - from A object");
		dataList.add(obj1);
		
		Intent i = new Intent(MainActivity.this, OtherActivity.class);
		i.putParcelableArrayListExtra("custom_data_list", dataList);
		//i.putExtra("com.package.ObjectA", obj);
		 
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
