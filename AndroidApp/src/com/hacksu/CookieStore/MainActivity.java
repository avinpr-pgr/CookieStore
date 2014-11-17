package com.hacksu.CookieStore;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import com.hacksu.CookieStore.TabAdapters.TabsPagerAdapter;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener
{
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    public static String submitInfo;
    // Tab titles
    private String[] tabs = { "Home", "Cart", "Confirm" };

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Initialization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }

        setupViewPagerListeners();
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
    {
        viewPager.setCurrentItem(tab.getPosition());
        if (tab.getPosition() == 1) {
            LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
            Intent i = new Intent("CART_TAB_REFRESH");
            lbm.sendBroadcast(i);
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)
    {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft)
    {

    }

    private void setupViewPagerListeners()
    {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
}
