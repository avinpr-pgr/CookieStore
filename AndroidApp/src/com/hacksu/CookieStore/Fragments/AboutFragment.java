package com.hacksu.CookieStore.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.hacksu.CookieStore.MainActivity;
import com.hacksu.CookieStore.MockData.CartItems;
import com.hacksu.CookieStore.R;

public class AboutFragment extends Fragment
{
    public static TextView aboutTextView;
    private String args;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.about_layout, container, false);
        aboutTextView = (TextView) rootView.findViewById(R.id.aboutSubmit);
        aboutTextView.setText("Go order some cookies now! D=<");
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        aboutTextView.setText("Go order some cookies now! D=<");
    }
}
