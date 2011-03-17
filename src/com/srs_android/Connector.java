package com.srs_android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Connector {
	private static final String LOG_TAG = "Connector";
	private static final boolean DBG = true;

	private static ConnectivityManager cm;
	private static NetworkInfo ni;

	private ApplicationState rec;

	public Connector(ApplicationState rec) {
		this.rec = rec;
	}

	public boolean hasInternetConnection(Context c) {
		if (cm == null) {
			cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
		}

		ni = cm.getActiveNetworkInfo();

		if (ni == null) {
			return false;
		}

		if (ni.getState() != NetworkInfo.State.CONNECTED) {
			return false;
		} else {
			return true;
		}
	}

	public InputStream openHttpConnection(String urlString, boolean propagateException) throws Exception {
		InputStream in = null;
		int response = -1;

		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();

		if (!(conn instanceof HttpURLConnection)) {
			throw new IOException("Not an HTTP connection");
		}

		try {
			HttpURLConnection httpConn = (HttpURLConnection) conn;

			httpConn.setAllowUserInteraction(false);
			httpConn.setInstanceFollowRedirects(true);
			httpConn.setRequestMethod("GET");
			httpConn.setConnectTimeout(Constants.CONNECT_TIMEOUT);
			httpConn.setReadTimeout(Constants.READ_TIMEOUT);
			httpConn.connect();

			response = httpConn.getResponseCode();

			if (response == HttpURLConnection.HTTP_OK) {
				in = httpConn.getInputStream();
			}
		} catch (Exception ex) {
			if (propagateException) {
				throw ex;
			} else {
				if (rec.activeActivity != null) {
					rec.activeActivity.runOnUiThread(new Runnable() {
						public void run() {
							Toast.makeText(rec.activeActivity, "The connection has timed out.", Toast.LENGTH_LONG).show();
						}
					});
				}
			}
		}

		return in;
	}

	public void sendRequest(String URL, boolean propagateException) throws Exception {
		openHttpConnection(URL, propagateException);
	}

	// Download JSON string
	public String downloadJSON(String URL, boolean propagateException) throws Exception {
		InputStream in = null;
		String jsonString = "";

		in = openHttpConnection(URL, propagateException);

		jsonString = convertStreamToString(in);

		return jsonString;
	}

	private String convertStreamToString(InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line = null;

		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}

		br.close();
		return sb.toString();
	}
}
