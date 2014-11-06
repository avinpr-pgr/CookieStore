package com.hacksu.CookieStore.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hacksu.CookieStore.R;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeFragment extends ListFragment
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

    private String tempData = "[\\r\\n{\\r\\n\\\"Category\\\":0,\\r\\n\\\"Id\\\":0, //Cookies\\r\\n\\\"Name\\\":\\\"Chocolate Chip\\\",\\r\\n\\\"Description\\\":\\\"Warm, gooey Chocolate Chips!\\\",\\r\\n\\\"Price\\\":1.0\\r\\n},\\r\\n{\\r\\n\\\"Category\\\":0,\\r\\n\\\"Id\\\":1,\\r\\n\\\"Name\\\":\\\"Peanut Butter\\\",\\r\\n\\\"Description\\\":\\\"Caution--May Contain Peanut Products\\\",\\r\\n\\\"Price\\\":1.25\\r\\n},\\r\\n{\\r\\n\\\"Category\\\":0,\\r\\n\\\"Id\\\":2,\\r\\n\\\"Name\\\":\\\"Sugar\\\",\\r\\n\\\"Description\\\":\\\"WHEEE!!\\\",\\r\\n\\\"Price\\\":1.5\\r\\n},\\r\\n{\\r\\n\\\"Category\\\":0,\\r\\n\\\"Id\\\":3,\\r\\n\\\"Name\\\":\\\"Oatmeal Raisin\\\",\\r\\n\\\"Description\\\":\\\"It's Oatmeal. It's Raisin. It's both!\\\",\\r\\n\\\"Price\\\":2.25\\r\\n},\\r\\n{\\r\\n\\\"Category\\\":1, // Milk\\r\\n\\\"Id\\\":4,\\r\\n\\\"Name\\\":\\\"Whole\\\",\\r\\n\\\"Description\\\":\\\"Pours like a milkshake\\\",\\r\\n\\\"Price\\\":0.5\\r\\n},\\r\\n{\\r\\n\\\"Category\\\":1,\\r\\n\\\"Id\\\":5,\\r\\n\\\"Name\\\":\\\"2%\\\",\\r\\n\\\"Description\\\":\\\"Just Like Mom used to buy\\\",\\r\\n\\\"Price\\\":0.75\\r\\n},\\r\\n{\\r\\n\\\"Category\\\":1,\\r\\n\\\"Id\\\":6,\\r\\n\\\"Name\\\":\\\"Skim\\\",\\r\\n\\\"Description\\\":\\\"To help you watch your waistline\\\",\\r\\n\\\"Price\\\":0.55\\r\\n},\\r\\n{\\r\\n\\\"Category\\\":1,\\r\\n\\\"Id\\\":7,\\r\\n\\\"Name\\\":\\\"Soy\\\",\\r\\n\\\"Description\\\":\\\"Well... this is really soy juice but who cares?\\\",\\r\\n\\\"Price\\\":1.3\\r\\n}\\r\\n]";
}
