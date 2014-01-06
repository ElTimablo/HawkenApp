package com.example.hawkencommunicator;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
//import android.text.Editable;

public class MainActivity extends Activity {
	public static final String URL_BASE = (String)"http://services.live.hawken.meteor-ent.com";
	public static final String EXTRA_MESSAGE = "com.example.hawkencommunicator.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void clickbutton(View v) {
		//Intent i = new Intent(this, DisplayMessageActivity.class);
		EditText e = (EditText) findViewById(R.id.textbox);
		//String message = e.getText().toString();
		HttpChecker chubby = new HttpChecker();
		chubby.execute("/version", "/version");
		String message = "";
		try {
			message = chubby.get();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.setText(message);
//		i.putExtra(EXTRA_MESSAGE, message);
//		startActivity(i);
	}

}
