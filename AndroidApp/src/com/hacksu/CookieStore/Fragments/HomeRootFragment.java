package com.hacksu.CookieStore.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hacksu.CookieStore.FragmentHelper;
import com.hacksu.CookieStore.R;

public class HomeRootFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.home_root, container, false);
        FragmentHelper.replaceFragment(R.id.homeRoot, "home", new HomeFragment(), getFragmentManager());
        return rootView;
    }
}
