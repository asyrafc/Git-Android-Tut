package com.example.androidtutorial;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;

public class XMLParserClass {

	public static ArrayList<String> InstituteArray;
	public static ArrayList<String> CityArray;
	public static ArrayList<String> NameArray;
	public static ArrayList<String> Off1_Array;
	public static ArrayList<String> Off2_Array;
	public static ArrayList<String> Off3_Array;
	public static ArrayList<String> Res1_Array;
	public static ArrayList<String> Res2_Array;
	public static ArrayList<String> Mob1_Array;
	public static ArrayList<String> Mob2_Array;
	public static ArrayList<String> Email1_Array;
	public static ArrayList<String> Email2_Array;
	Context c;

	public XMLParserClass(Context context) throws XmlPullParserException,
			IOException {
		// TODO Auto-generated constructor stub
		InstituteArray = new ArrayList<String>();
		CityArray = new ArrayList<String>();
		Email1_Array = new ArrayList<String>();
		Email2_Array = new ArrayList<String>();
		NameArray = new ArrayList<String>();
		Off1_Array = new ArrayList<String>();
		Off2_Array = new ArrayList<String>();
		Off3_Array = new ArrayList<String>();
		Res1_Array = new ArrayList<String>();
		Res2_Array = new ArrayList<String>();
		Mob1_Array = new ArrayList<String>();
		Mob2_Array = new ArrayList<String>();
			
		c = context;
		Resources res = c.getResources();
		XmlResourceParser xrp = res.getXml(R.xml.contacts);

		xrp.next(); // May throw error show add exceptions to the file
		int eventType = xrp.getEventType();
		
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_TAG) {
				if (xrp.getName().equals(("Name"))) {
					NameArray.add(xrp.nextText());
				}
				if (xrp.getName().equals(("Institute"))) {
					InstituteArray.add(xrp.nextText());
				}
				if (xrp.getName().equals(("City"))) {
					CityArray.add(xrp.nextText());
				}
				if (xrp.getName().equals(("O1"))) {
					Off1_Array.add(xrp.nextText());
				}
				if (xrp.getName().equals(("O2"))) {
					Off2_Array.add(xrp.nextText());
				}
				if (xrp.getName().equals(("O3"))) {
					Off3_Array.add(xrp.nextText());
				}
				if (xrp.getName().equals(("R1"))) {
					Res1_Array.add(xrp.nextText());
				}
				if (xrp.getName().equals(("R2"))) {
					Res2_Array.add(xrp.nextText());
				}
				if (xrp.getName().equals(("M1"))) {
					Mob1_Array.add(xrp.nextText());
				}
				if (xrp.getName().equals(("M2"))) {
					Mob2_Array.add(xrp.nextText());
				}
				if (xrp.getName().equals(("E1"))) {
					Email1_Array.add(xrp.nextText());
				}
				if (xrp.getName().equals(("E2"))) {
					Email2_Array.add(xrp.nextText());
				}
			}
			eventType = xrp.next();
		}
	}
}
