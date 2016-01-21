package com.example.androidtutorial;

public class ContactItemObject {
	private String Name;
	private String BottomText;
	
	public String getName(){
		return this.Name;
	}
	
	public String getBottomText(){
		return this.BottomText;
	}
	
	public void setName(String name){
		this.Name = name;
	}
	
	public void setBottomText(String bottomText){
		this.BottomText = bottomText;
	}
}
