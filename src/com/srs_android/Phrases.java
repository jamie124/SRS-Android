package com.srs_android;

import java.util.HashMap;

public class Phrases {
	HashMap<String, String> phraseList;

	public Phrases() {
		phraseList = new HashMap<String, String>();

		// Login Screen
		phraseList.put("start_screen_username", "Username:");
		phraseList.put("start_screen_password", "Password:");
		phraseList.put("start_screen_details_missing", "The Username and/or Password fields are Missing");
		phraseList.put("password_incorrect", "The Provided Password is Incorrect");

		// Main Screen
		phraseList.put("main_screen_server_name", "Server Name: ");
		phraseList.put("main_screen_user_name", "User Name: ");
		phraseList.put("main_screen_user_role", "User Role: ");
		phraseList.put("main_screen_no_question", "There are no questions available");
		phraseList.put("main_screen_question_available", "There is a new question available");
		phraseList.put("main_screen_answer_question", "Answer Question");
		phraseList.put("main_screen_user_options", "User Options");
	}

	public String getPhrase(String phraseKey) {
		if (phraseList.containsKey(phraseKey)) {
			return phraseList.get(phraseKey);
		}
		return phraseKey;
	}
}
