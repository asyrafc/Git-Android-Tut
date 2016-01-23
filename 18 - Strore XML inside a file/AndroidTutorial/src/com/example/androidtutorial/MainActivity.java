package com.example.androidtutorial;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ArrayList<ContactItemObject> ContactItemArray;
	MyCustomBaseAdapter myAdapter;
	EditText SearchET;
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ContactItemArray = MakeArrayList();
		lv = (ListView) findViewById(R.id.Contacts_list_view);
		SearchET = (EditText) findViewById(R.id.SearchET);

		myAdapter = new MyCustomBaseAdapter(getApplicationContext(),
				ContactItemArray);
		lv.setAdapter(myAdapter);

		MyTextWatcher mytextwatcher = new MyTextWatcher();
		SearchET.addTextChangedListener(mytextwatcher);
		lv.setOnItemClickListener(new AllContactListViewClickListener());

	}

	public class AllContactListViewClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			int Index = ((ContactItemObject) arg0.getItemAtPosition(arg2))
					.getIndex();
			Intent i = new Intent(getApplicationContext(),
					PersonDetailListView.class);
			i.putExtra("index", Index);
			Log.d("hello", "Position Clicked is " + arg2);
			Log.d("hello", "Item Clicked is " + Index);
			startActivity(i);
		}

	}

	private ArrayList<ContactItemObject> MakeArrayList() {
		ArrayList<ContactItemObject> TempItemArray = new ArrayList<ContactItemObject>();
		for (int i = 0; i < XMLParserClass.NameArray.size(); i++) {
			ContactItemObject CIO = new ContactItemObject();
			CIO.setName(XMLParserClass.NameArray.get(i));
			CIO.setBottomText(XMLParserClass.CityArray.get(i));
			CIO.setIndex(i);
			TempItemArray.add(CIO);
		}
		return TempItemArray;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.UpdateContactsMain:
			Toast.makeText(getApplicationContext(),"Updating....", Toast.LENGTH_SHORT).show();
			GetDataAsyncTask getDataTask = new GetDataAsyncTask();
			getDataTask.execute(this);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public class MyTextWatcher implements TextWatcher {

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			myAdapter.getFilter().filter(arg0.toString());
		}

	}

}
