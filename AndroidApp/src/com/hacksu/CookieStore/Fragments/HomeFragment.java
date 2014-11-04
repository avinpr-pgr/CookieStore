package com.hacksu.CookieStore.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hacksu.CookieStore.R;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.home_layout, container, false);

        return rootView;
    }

    private JSONObject getData()
    {
        JSONObject data = null;
        try
        {
            data = new JSONObject(tempData);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return data;
    }

    private String tempData = "{\\r\\n\\\"Products\\\": [\\r\\n{\\r\\n\\\"Category\\\": \\\"Cookie\\\",\\r\\n\\\"Items\\\": [\\r\\n{\\r\\n\\\"id\\\": 1,\\r\\n\\\"description\\\": \\\"Peanut butter\\\",\\r\\n\\\"price\\\": 15\\r\\n},\\r\\n{\\r\\n\\\"id\\\": 2,\\r\\n\\\"description\\\": \\\"Bacon\\\",\\r\\n\\\"price\\\": 5\\r\\n}\\r\\n]\\r\\n},\\r\\n{\\r\\n\\\"Category\\\": \\\"Milk\\\",\\r\\n\\\"Items\\\": [\\r\\n{\\r\\n\\\"id\\\": 3,\\r\\n\\\"description\\\": \\\"Chocolate milk\\\",\\r\\n\\\"price\\\": 15\\r\\n},\\r\\n{\\r\\n\\\"id\\\": 4,\\r\\n\\\"description\\\": \\\"Organic\\\",\\r\\n\\\"price\\\": 15\\r\\n}\\r\\n]\\r\\n}\\r\\n]\\r\\n}";
}
