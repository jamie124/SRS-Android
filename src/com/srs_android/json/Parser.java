package com.srs_android.json;


import com.google.gson.Gson;
import com.srs_android.Question;
import com.srs_android.user.User;

public class Parser {

	public static User parseUserData(String jsonString){
		Gson gson = new Gson();
		
		return gson.fromJson(jsonString, User.class);
	}
	
	public static Question parseQuestionData(String jsonString){
		Gson gson = new Gson();
		
		return gson.fromJson(jsonString, Question.class);
	}
}
