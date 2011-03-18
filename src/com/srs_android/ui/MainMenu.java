package com.srs_android.ui;

import com.srs_android.ApplicationState;
import com.srs_android.R;

import android.app.Activity;
import android.os.Bundle;


public class MainMenu extends Activity {
	ApplicationState rec;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);

		rec = new ApplicationState();
	}
	
	@Override
	public void onResume(){
		super.onResume();
		
		rec.activeActivity = this;
	}
}
