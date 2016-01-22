package com.example.androidtutorial;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
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
		
		Intent i = getIntent();
		int Index = i.getIntExtra("index", 0);
		DetailList = getPersonalDetails(Index);
		
		lv = (ListView) findViewById(R.id.person_details_lv);
		myPersonDetailListViewAdapter = new PersonDetailListViewAdapter(this,
				DetailList);
		lv.setAdapter(myPersonDetailListViewAdapter);
	}

	private ArrayList<PersonDetailListItem> getPersonalDetails(int Index){
		ArrayList<PersonDetailListItem> DetailList = new ArrayList<PersonDetailListItem>();

		PersonDetailListItem sr = new PersonDetailListItem();
		sr.setDetailName("Name");
		sr.setDetailValue(XMLParserClass.NameArray.get(Index));
		DetailList.add(sr);

		sr = new PersonDetailListItem();
		sr.setDetailName("Institute");
		sr.setDetailValue(XMLParserClass.InstituteArray.get(Index));
		DetailList.add(sr);

		if (!(XMLParserClass.Off1_Array.get(Index).equals(""))) {
			sr = new PersonDetailListItem();
			sr.setDetailName("Office");
			sr.setDetailValue(XMLParserClass.Off1_Array.get(Index));
			DetailList.add(sr);
		}
		
		if (!(XMLParserClass.Off2_Array.get(Index).equals(""))) {
			sr = new PersonDetailListItem();
			sr.setDetailName("Office");
			sr.setDetailValue(XMLParserClass.Off2_Array.get(Index));
			DetailList.add(sr);
		}
		
		if (!(XMLParserClass.Off3_Array.get(Index).equals(""))) {
			sr = new PersonDetailListItem();
			sr.setDetailName("Office");
			sr.setDetailValue(XMLParserClass.Off3_Array.get(Index));
			DetailList.add(sr);
		}

		if (!(XMLParserClass.Res1_Array.get(Index).equals(""))) {
			sr = new PersonDetailListItem();
			sr.setDetailName("Residence");
			sr.setDetailValue(XMLParserClass.Res1_Array.get(Index));
			DetailList.add(sr);
		}
		if (!(XMLParserClass.Res2_Array.get(Index).equals(""))) {
			sr = new PersonDetailListItem();
			sr.setDetailName("Residence");
			sr.setDetailValue(XMLParserClass.Res2_Array.get(Index));
			DetailList.add(sr);
		}
		
		if (!(XMLParserClass.Mob1_Array.get(Index).equals(""))) {
			sr = new PersonDetailListItem();
			sr.setDetailName("Mobile");
			sr.setDetailValue(XMLParserClass.Mob1_Array.get(Index));
			DetailList.add(sr);
		}
		if (!(XMLParserClass.Mob2_Array.get(Index).equals(""))) {
			sr = new PersonDetailListItem();
			sr.setDetailName("Mobile");
			sr.setDetailValue(XMLParserClass.Mob2_Array.get(Index));
			DetailList.add(sr);
		}
		
		if (!(XMLParserClass.Email1_Array.get(Index).equals(""))) {
			sr = new PersonDetailListItem();
			sr.setDetailName("Email");
			sr.setDetailValue(XMLParserClass.Email1_Array.get(Index));
			DetailList.add(sr);
		}
		
		if (!(XMLParserClass.Email2_Array.get(Index).equals(""))) {
			sr = new PersonDetailListItem();
			sr.setDetailName("Email");
			sr.setDetailValue(XMLParserClass.Email2_Array.get(Index));
			DetailList.add(sr);
		}
		
		sr = new PersonDetailListItem();
		sr.setDetailName("City");
		sr.setDetailValue(XMLParserClass.CityArray.get(Index));
		DetailList.add(sr);

		return DetailList;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.person_detail_list_view, menu);
		return true;
	}

}
