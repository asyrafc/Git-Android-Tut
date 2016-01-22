package com.example.androidtutorial;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SpreadSheetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spread_sheet);
		
		GetDataAsyncTask myTask = new GetDataAsyncTask();
		myTask.execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spread_sheet, menu);
		return true;
	}

}
