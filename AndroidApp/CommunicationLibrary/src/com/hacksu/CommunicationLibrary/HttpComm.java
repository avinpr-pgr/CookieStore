package com.hacksu.CommunicationLibrary;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class HttpComm
{
    public static HttpResponse makeGetRequest(String uri)
    {
        HttpResponse response = null;
        try
        {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(uri);

            response = httpClient.execute(httpGet);
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return response;
    }

    public static HttpResponse makePostRequest(String uri)
    {
        HttpResponse response = null;
        try
        {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(uri);

            List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
            nameValuePair.add(new BasicNameValuePair("username", "test_user"));
            nameValuePair.add(new BasicNameValuePair("password", "123456789"));

            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));

            response = httpClient.execute(httpPost);
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return response;
    }

    public static HttpResponse makePutRequest(String uri)
    {
        HttpResponse response = null;
        try
        {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPut httpPut = new HttpPut(uri);

            List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
            nameValuePair.add(new BasicNameValuePair("username", "test_user"));
            nameValuePair.add(new BasicNameValuePair("password", "123456789"));

            httpPut.setEntity(new UrlEncodedFormEntity(nameValuePair));

            response = httpClient.execute(httpPut);
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return response;
    }

    public static HttpResponse makeDeleteRequest(String uri)
    {
        HttpResponse response = null;
        try
        {
            HttpClient httpClient = new DefaultHttpClient();
            HttpDelete httpDelete = new HttpDelete(uri);

            response = httpClient.execute(httpDelete);
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return response;
    }
}
