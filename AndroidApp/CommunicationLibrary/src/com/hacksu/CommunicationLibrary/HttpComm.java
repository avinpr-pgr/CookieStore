package com.hacksu.CommunicationLibrary;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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

    public static HttpResponse makePostRequest(String uri, JSONObject data)
    {
        HttpResponse response = null;
        try
        {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(uri);

            StringEntity stringEntity = new StringEntity(data.toString());
            stringEntity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpPost.setEntity(stringEntity);

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

    public static HttpResponse makePutRequest(String uri, JSONObject data)
    {
        HttpResponse response = null;
        try
        {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPut httpPut = new HttpPut(uri);

            StringEntity stringEntity = new StringEntity(data.toString());
            stringEntity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpPut.setEntity(stringEntity);

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
