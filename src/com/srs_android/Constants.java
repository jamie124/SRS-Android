package com.srs_android;

public class Constants {

	public static final boolean DEBUG = true;
	public static final String SRS_SERVER_DEBUG = "http://192.168.1.74:8080";
	//public static final String SRS_SERVER_DEBUG = "http://192.168.1.64:8080";
	public static final String SRS_SERVER = "http://192.168.1.64:8080";
	
	public static final String SRS_GATEWAY = "/srs_web_server/Server";
	
	public static final int CONNECT_TIMEOUT = 15000;
	public static final int READ_TIMEOUT = 15000;
	
	// REST calls
	public static final String REST_USER_LOGIN = "?r=login&username=%s&password=%s";
	public static final String REST_GET_USER = "?r=getUser&username=%s&password=%s";
	public static final String REST_CHECK_FOR_QUESTION = "?r=getQuestion&username=%s";
}
