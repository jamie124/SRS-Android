package com.srs_android.ui;

import java.util.Timer;
import java.util.TimerTask;

import com.srs_android.ApplicationState;
import com.srs_android.Constants;
import com.srs_android.R;
import com.srs_android.json.Parser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends Activity {
	ApplicationState rec;

	private TextView serverName, userName, userRole, questionAvailable;
	private Button answerQuestion, userOptions;

	Timer questionTimer;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);

		rec = (ApplicationState) getApplication();

		serverName = (TextView) findViewById(R.id.serverName);
		userName = (TextView) findViewById(R.id.userName);
		userRole = (TextView) findViewById(R.id.userRole);
		questionAvailable = (TextView) findViewById(R.id.questionAvailable);

		answerQuestion = (Button) findViewById(R.id.selectAnswerQuestion);
		userOptions = (Button) findViewById(R.id.selectUserOptions);

		serverName.setText(rec.phrases.getPhrase("main_screen_server_name") + "Unknown");
		userName.setText(rec.phrases.getPhrase("main_screen_user_name") + rec.user.userName());
		userRole.setText(rec.phrases.getPhrase("main_screen_user_role") + rec.user.userRole());

		questionAvailable.setText(rec.phrases.getPhrase("main_screen_no_question"));
		answerQuestion.setText(rec.phrases.getPhrase("main_screen_answer_question"));
		userOptions.setText(rec.phrases.getPhrase("main_screen_user_options"));

		answerQuestion.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		userOptions.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		questionTimer = new Timer("Question Timer");
		questionTimer.schedule(new TimerTask() {
			public void run() {
				runOnUiThread(new Runnable() {
					public void run() {
						if (rec.checkForQuestion()) {
							checkForNewQuestion();

							if (rec.user.questionAvailable())
								questionAvailable.setText(rec.phrases.getPhrase("main_screen_question_available"));
							else
								questionAvailable.setText(rec.phrases.getPhrase("main_screen_no_question"));
							
							rec.checkForQuestion(false);
						}
					}
				});
			}
		}, 100, 10000);
	}

	private void checkForNewQuestion() {
		String url = "";

		if (Constants.DEBUG)
			url = Constants.SRS_SERVER_DEBUG;
		else
			url = Constants.SRS_SERVER;

		url += Constants.SRS_GATEWAY;

		try {

			String response = rec.connector.sendRequest(String.format(url + Constants.REST_CHECK_FOR_QUESTION, rec.user.userName()), false);
			rec.question = (Parser.parseQuestionData(response));
			rec.user.questionAvailable(true);

		} catch (Exception ex) {

		}
	}

	@Override
	public void onResume() {
		super.onResume();

		rec.activeActivity = this;
	}
}
