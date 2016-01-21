package com.example.androidtutorial;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	String[] NameArray;
	String[] BottomTextArray;
	ArrayList<ContactItemObject> ContactItemArray;
	MyCustomBaseAdapter myAdapter;
	EditText SearchET;
	ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		NameArray = getResources().getStringArray(R.array.NameArray);
		BottomTextArray = getResources().getStringArray(R.array.BottomTextArray);
		ContactItemArray = MakeArrayList();
		lv = (ListView)findViewById(R.id.Contacts_list_view);
		SearchET = (EditText)findViewById(R.id.SearchET);
		
		myAdapter = new MyCustomBaseAdapter(getApplicationContext(), ContactItemArray);
		lv.setAdapter(myAdapter);
		
		MyTextWatcher mytextwatcher = new MyTextWatcher();
		SearchET.addTextChangedListener(mytextwatcher);

	}
	
	private ArrayList<ContactItemObject> MakeArrayList(){
		ArrayList<ContactItemObject> TempItemArray = new ArrayList<ContactItemObject>();
		for (int i = 0; i < NameArray.length; i++) {
			ContactItemObject CIO = new ContactItemObject();
			CIO.setName(NameArray[i]);
			CIO.setBottomText(BottomTextArray[i]);
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
	
	public class MyTextWatcher implements TextWatcher{

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
			Log.d("hello",arg0.toString());
			myAdapter.getFilter().filter(arg0.toString());
		}
		
	}

}
