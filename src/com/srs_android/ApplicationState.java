package com.srs_android;

import com.srs_android.user.User;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

public class ApplicationState extends Application {

	private static final String LOG_TAG = "State";

	public Phrases phrases;
	public Context context;
	public Activity activeActivity = null;
	public Connector connector;
	public User user = null;
	public Question question = null;

	@Override
	public void onCreate() {
		super.onCreate();

		context = getApplicationContext();

		connector = new Connector(this);

		phrases = new Phrases();
	}
}
