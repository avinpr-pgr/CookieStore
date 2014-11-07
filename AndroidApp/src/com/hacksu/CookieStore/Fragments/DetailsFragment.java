package com.hacksu.CookieStore.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hacksu.CookieStore.R;

public class DetailsFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.details_layout, container, false);

        Bundle args = getArguments();
        String test = args.getString("name");
        return rootView;
    }
}
