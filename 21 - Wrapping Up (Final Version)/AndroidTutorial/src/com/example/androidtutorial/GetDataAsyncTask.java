package com.example.androidtutorial;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class GetDataAsyncTask extends AsyncTask<Activity, Void, Void> {

	Activity myActivity;
	@Override
	protected Void doInBackground(Activity... arg0) {
		// TODO Auto-generated method stub
		myActivity = arg0[0];
		
		try {
			getData();
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String xmlString = XMLCreator.CreateSpreadSheetToXML();
			FileOperations.StoreData(xmlString);
//			Log.d("hello",xmlString);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		Intent i = new Intent(myActivity.getApplicationContext(),MainActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
		myActivity.startActivity(i);
		myActivity.overridePendingTransition(0, 0);
		myActivity.finish();
	}
	
	private void getData() throws AuthenticationException,
			MalformedURLException, IOException, ServiceException,
			URISyntaxException {
		// TODO Auto-generated method stub
		SpreadsheetService service = new SpreadsheetService(
				"MySpreadsheetIntegration-v1");
		service.setProtocolVersion(SpreadsheetService.Versions.V3);

		URL SPREADSHEET_URL = new URL(
				"https://spreadsheets.google.com/feeds/worksheets/123ESdfGd9gdhaJjKeluoAK_ESjo4JWHP6HGKebUX1Eo/public/full");

		WorksheetFeed feed = service.getFeed(SPREADSHEET_URL,
				WorksheetFeed.class);
		List<WorksheetEntry> worksheets = feed.getEntries();
		WorksheetEntry worksheet = worksheets.get(0);
		Log.d("hello", "Worksheet name is "
				+ worksheet.getTitle().getPlainText());

		// URL listFeedUrl = worksheet.getListFeedUrl();
		URL listFeedUrl = new URI(worksheet.getListFeedUrl().toString())
				.toURL();

		Log.d("hello", "URL is \n " + listFeedUrl.toString());

		ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);

		ArrayList<String> InstituteArray = new ArrayList<String>();
		ArrayList<String> CityArray = new ArrayList<String>();
		ArrayList<String> Email1_Array = new ArrayList<String>();
		ArrayList<String> Email2_Array = new ArrayList<String>();
		ArrayList<String> NameArray = new ArrayList<String>();
		ArrayList<String> S_No_Array = new ArrayList<String>();
		ArrayList<String> Off1_Array = new ArrayList<String>();
		ArrayList<String> Off2_Array = new ArrayList<String>();
		ArrayList<String> Off3_Array = new ArrayList<String>();
		ArrayList<String> Res1_Array = new ArrayList<String>();
		ArrayList<String> Res2_Array = new ArrayList<String>();
		ArrayList<String> Mob1_Array = new ArrayList<String>();
		ArrayList<String> Mob2_Array = new ArrayList<String>();
		ArrayList<String> Tag_Array = new ArrayList<String>();
		
		ListEntry TempList = listFeed.getEntries().get(0);
		for(String tag:TempList.getCustomElements().getTags()){
			Tag_Array.add(tag);
		}
		
		for (ListEntry row : listFeed.getEntries()) {
			for (String tag : row.getCustomElements().getTags()) {
				if (tag.equals("s.no.")) {
					S_No_Array.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
				if (tag.equals("name")) {
					NameArray.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
				if (tag.equals("institute")) {
					InstituteArray.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
				if (tag.equals("city")) {
					CityArray.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
				if (tag.equals("o1")) {
					Off1_Array.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
				if (tag.equals("o2")) {
					Off2_Array.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
				if (tag.equals("o3")) {
					Off3_Array.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
				if (tag.equals("r1")) {
					Res1_Array.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
				if (tag.equals("r2")) {
					Res2_Array.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
				if (tag.equals("m1")) {
					Mob1_Array.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
				if (tag.equals("m2")) {
					Mob2_Array.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
				if (tag.equals("e1")) {
					Email1_Array.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
				if (tag.equals("e2")) {
					Email2_Array.add(ProperValue(row.getCustomElements()
							.getValue(tag)));
				}
			}
			
		}	
		
		XMLParserClass.InstituteArray = InstituteArray;
		XMLParserClass.CityArray = CityArray;
		XMLParserClass.Email1_Array = Email1_Array;
		XMLParserClass.Email2_Array = Email2_Array;
		XMLParserClass.NameArray = NameArray;
		XMLParserClass.Off1_Array = Off1_Array;
		XMLParserClass.Off2_Array = Off2_Array;
		XMLParserClass.Off3_Array = Off3_Array;
		XMLParserClass.Res1_Array = Res1_Array;
		XMLParserClass.Res2_Array = Res2_Array;
		XMLParserClass.Mob1_Array = Mob1_Array;
		XMLParserClass.Mob2_Array = Mob2_Array;
		XMLParserClass.Tag_Array = Tag_Array;
		
	}

	public String ProperValue(String input) {
		if (input == null) {
			return new String("");
		} else {
			return input;
		}

	}

}
