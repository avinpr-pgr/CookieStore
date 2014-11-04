package com.hacksu.CookieStore.TabAdapters;

import android.support.v4.app.*;
import com.hacksu.CookieStore.Fragments.AboutFragment;
import com.hacksu.CookieStore.Fragments.CartFragment;
import com.hacksu.CookieStore.Fragments.HomeFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter
{

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new HomeFragment();
            case 1:
                // Games fragment activity
                return new CartFragment();
            case 2:
                // Movies fragment activity
                return new AboutFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}