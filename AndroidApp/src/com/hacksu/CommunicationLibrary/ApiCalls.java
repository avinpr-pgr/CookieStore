package com.hacksu.CommunicationLibrary;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by dpendle on 11/11/2014.
 */
public class ApiCalls extends AsyncTask<Void, Void, JSONObject> {
    private String urlname;
    private JSONObject jsonObjSend;
    private final String TAG = "HttpClient";
    private JSONObject result = null;

    public ApiCalls(String URL, JSONObject jsonObjSend) {
        this.urlname = URL;
        this.jsonObjSend = jsonObjSend;
    }

    private Exception exception;

    @Override
    protected JSONObject doInBackground(Void... params) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPut httpPostRequest = new HttpPut(this.urlname);

            StringEntity se;
            se = new StringEntity(jsonObjSend.toString());

            // Set HTTP parameters
            httpPostRequest.setEntity(se);
            httpPostRequest.setHeader("Accept", "application/json");
            httpPostRequest.setHeader("Content-type", "application/json");

            long t = System.currentTimeMillis();
            HttpResponse response = (HttpResponse) httpclient.execute(httpPostRequest);
            Log.i(TAG, "HTTPResponse received in [" + (System.currentTimeMillis() - t) + "ms]");

            HttpEntity entity = response.getEntity();
            String responseStr = EntityUtils.toString(entity);
            JSONObject json = new JSONObject(responseStr);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}


