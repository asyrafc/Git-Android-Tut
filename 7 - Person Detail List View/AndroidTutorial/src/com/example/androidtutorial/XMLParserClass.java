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

	public static ArrayList<String> NameArray;
	public static ArrayList<String> BottomArray;

	Context c;

	public XMLParserClass(Context context) throws XmlPullParserException,
			IOException {
		// TODO Auto-generated constructor stub
		NameArray = new ArrayList<String>();
		BottomArray = new ArrayList<String>();
		c = context;
		Resources res = c.getResources();
		XmlResourceParser xrp = res.getXml(R.xml.contacts);

		xrp.next(); // May throw error show add exceptions to the file
		int eventType = xrp.getEventType();
		
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_TAG) {
				if (xrp.getName().equals("Name")) {
					NameArray.add(xrp.nextText());
				}
				if (xrp.getName().equals("Bottom")) {
					BottomArray.add(xrp.nextText());
				}
			}
			eventType = xrp.next();
		}
	}
}
