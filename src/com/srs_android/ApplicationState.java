package com.srs_android;


import android.app.Activity;
import android.content.Context;

public class ApplicationState {

	public Phrases phrases;
	public Context context;
	public Activity activeActivity = null;
	public Connector connector;
	
	public ApplicationState(){
		phrases = new Phrases();
		connector = new Connector(this);
	}
}
