package com.example.androidtutorial;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class PersonDetailListView extends Activity {

	ListView lv;
	PersonDetailListViewAdapter myPersonDetailListViewAdapter;
	ArrayList<PersonDetailListItem> DetailList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_detail_list_view);
		
		PersonDetailListItem Detail1 = new PersonDetailListItem("Name","Name Value");
		PersonDetailListItem Detail2 = new PersonDetailListItem("Mobile","Mobile Value");
		PersonDetailListItem Detail3 = new PersonDetailListItem("Email","Email Value");
		DetailList = new ArrayList<PersonDetailListItem>();
		DetailList.add(Detail1);
		DetailList.add(Detail2);
		DetailList.add(Detail3);
		
		lv = (ListView) findViewById(R.id.person_details_lv);
		myPersonDetailListViewAdapter = new PersonDetailListViewAdapter(this,
				DetailList);
		lv.setAdapter(myPersonDetailListViewAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.person_detail_list_view, menu);
		return true;
	}

}
