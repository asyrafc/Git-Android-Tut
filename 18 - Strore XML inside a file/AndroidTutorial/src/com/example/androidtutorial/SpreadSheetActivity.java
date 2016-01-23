package com.example.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SpreadSheetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spread_sheet);

		GetDataAsyncTask myTask = new GetDataAsyncTask();
		myTask.execute(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spread_sheet, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.UpdateContactsSpreadSheet:
			GetDataAsyncTask getDataTask = new GetDataAsyncTask();
			getDataTask.execute(this);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
