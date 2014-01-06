package com.example.hawkencommunicator;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;

public class HttpChecker extends AsyncTask<String, Integer, String>{
//	public static final String URL_BASE = (String) ;
	protected String doInBackground(String... command) {
		//TODO: Write this shit
		String responseString = "";
		int TIMEOUT = 10000;
		try {
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT);
			HttpClient client = new DefaultHttpClient(httpParams);
			HttpPost post = new HttpPost("services.live.hawken.meteor-ent.com/version"); // + command
			post.setEntity(new ByteArrayEntity(postMessage.toString().getBytes("UTF8")));
			HttpResponse response = client.execute(post);
			responseString = EntityUtils.toString(response.getEntity());
			Log.d("Response", responseString);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseString;
	}
}
