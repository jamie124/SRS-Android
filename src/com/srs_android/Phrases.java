package com.srs_android;

import java.util.HashMap;

public class Phrases {
	HashMap<String, String> phraseList;
	
	public Phrases(){
		phraseList = new HashMap<String, String>();
		
		// Start Screen
		phraseList.put("start_screen_username", "Username:");
		phraseList.put("start_screen_password", "Password:");
		phraseList.put("start_screen_details_missing", "The Username and/or Password fields are Missing");
		phraseList.put("password_incorrect", "The Provided Password is Incorrect");
	}
	
	public String getPhrase(String phraseKey){
		if (phraseList.containsKey(phraseKey)){
			return phraseList.get(phraseKey);
		}
		return phraseKey;
	}
}
