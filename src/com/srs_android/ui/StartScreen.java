package com.srs_android.ui;

import java.util.logging.Logger;

import com.srs_android.ApplicationState;
import com.srs_android.Constants;
import com.srs_android.R;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StartScreen extends Activity {

	ApplicationState rec;

	TextView username, password;
	EditText enterUsername, enterPassword;
	Button login;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		rec = new ApplicationState();

		rec.context = getApplicationContext();

		username = (TextView) findViewById(R.id.username);
		password = (TextView) findViewById(R.id.password);

		enterUsername = (EditText) findViewById(R.id.enterUsername);
		enterPassword = (EditText) findViewById(R.id.enterPassword);

		login = (Button) findViewById(R.id.login);

		username.setText(rec.phrases.getPhrase("start_screen_username"));
		password.setText(rec.phrases.getPhrase("start_screen_password"));

		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				doLogin(enterUsername.getText().toString(), enterPassword.getText().toString());
			}
		});

	}

	private void doLogin(String username, String password) {
		if (username.equals("") || password.equals("")) {
			Toast.makeText(rec.context, rec.phrases.getPhrase("start_screen_details_missing"), Toast.LENGTH_SHORT).show();
		} else {
			String url = "";

			if (Constants.DEBUG)
				url = Constants.SRS_SERVER_DEBUG;

			url += Constants.SRS_GATEWAY + "?r=login&username=" + username + "&password=" + password;

			try {
				String response = rec.connector.sendRequest(url, false);
				
				if (response.equals("202")){
					startActivity(new Intent(StartScreen.this, MainMenu.class));
				} else if (response.equals("401")){
					Toast.makeText(rec.context, rec.phrases.getPhrase("password_incorrect"), Toast.LENGTH_SHORT).show();
				}
			} catch (Exception ex) {
				
			}
		}
	}

	@Override
	public void onResume() {
		super.onResume();

		rec.activeActivity = this;
	}
}