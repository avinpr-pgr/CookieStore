package com.hacksu.CookieStore.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.hacksu.CookieStore.FragmentHelper;
import com.hacksu.CookieStore.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class HomeFragment extends ListFragment
{
    private ListView listView;
    private HashMap<String, String> categories = new HashMap<String, String>();
    private ArrayList<Map<String, String>> productList = new ArrayList<Map<String, String>>();
    private HashMap<String, String> ids = new HashMap<String, String>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.home_layout, container, false);
        initializeCategories();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        listView = getListView();
        setupListAdapter();
        setupListViewListeners();
    }

    private void initializeCategories()
    {
        categories.put("0", "Cookies");
        categories.put("1", "Milk");
    }

    private void setupListAdapter()
    {
        JSONArray data = getData();
        List<String> viewableList = createViewableList(data);
        ListAdapter listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, viewableList);
        listView.setAdapter(listAdapter);
    }

    private void setupListViewListeners()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Map<String, String> map = productList.get(position);
                Bundle bundle = new Bundle();
                if (map.containsKey("NotAProduct")) return;
                bundle.putString("id", map.get("Id"));
                bundle.putString("name", map.get("Name"));
                bundle.putString("description", map.get("Description"));

                DetailsFragment fragment = new DetailsFragment();
                fragment.setArguments(bundle);
                FragmentHelper.showFragment(R.id.homeRoot, "home", HomeFragment.this, "details", fragment, getFragmentManager());
            }
        });
    }

    private ArrayList<String> createViewableList(JSONArray data)
    {
        ArrayList<String> viewableList = new ArrayList<String>();
        ArrayList<Map<String, String>> processedData = JSONToArray(data);
        ArrayList<String> addedCategories = new ArrayList<String>();
        for (Map<String, String> map : processedData)
        {
            String category = map.get("Category");
            if (!addedCategories.contains(category))
            {
                viewableList.add(categories.get(category));
                HashMap<String, String> temp = new HashMap<String, String>();
                temp.put("NotAProduct", categories.get(category));
                productList.add(temp);
                addedCategories.add(category);
            }
            viewableList.add(map.get("Name"));
            productList.add(map);
        }

        return viewableList;
    }

    private ArrayList<Map<String, String>> JSONToArray(JSONArray json)
    {
        ArrayList<Map<String, String>> data = new  ArrayList<Map<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        try
        {
            for (int i = 0; i < json.length(); ++i)
            {
                JSONObject jsonObject = json.getJSONObject(i);
                Iterator<?> keys = jsonObject.keys();

                while( keys.hasNext() ){
                    String key = (String)keys.next();
                    map.put(key, jsonObject.get(key).toString());
                }
                data.add(map);
                map = new HashMap<String, String>();
            }
        }
        catch(JSONException e)
        {
            // do nothing
        }
        return data;
    }

    private JSONArray getData()
    {
        JSONArray data = null;
        try
        {
            data = new JSONArray(tempData);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return data;
    }

    private String tempData = "[{\"Category\":0,\"Id\":0,\"Name\":\"Chocolate Chip\",\"Description\":\"Warm, gooey Chocolate Chips!\",\"Price\":1.0},{\"Category\":0,\"Id\":1,\"Name\":\"Peanut Butter\",\"Description\":\"Caution--May Contain Peanut Products\",\"Price\":1.25},{\"Category\":0,\"Id\":2,\"Name\":\"Sugar\",\"Description\":\"WHEEE!!\",\"Price\":1.5},{\"Category\":0,\"Id\":3,\"Name\":\"Oatmeal Raisin\",\"Description\":\"It's Oatmeal. It's Raisin. It's both!\",\"Price\":2.25},{\"Category\":1,\"Id\":4,\"Name\":\"Whole\",\"Description\":\"Pours like a milkshake\",\"Price\":0.5},{\"Category\":1,\"Id\":5,\"Name\":\"2%\",\"Description\":\"Just Like Mom used to buy\",\"Price\":0.75},{\"Category\":1,\"Id\":6,\"Name\":\"Skim\",\"Description\":\"To help you watch your waistline\",\"Price\":0.55},{\"Category\":1,\"Id\":7,\"Name\":\"Soy\",\"Description\":\"Well... this is really soy juice but who cares?\",\"Price\":1.3}]";
}
