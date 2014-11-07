package com.hacksu.CookieStore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentHelper
{
    public static void showFragment(int container, String currentFragmentTag, Fragment currentFragment, String newFragmentTag, Fragment newFragment, FragmentManager fragmentManager)
    {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.remove(currentFragment);
        transaction.add(container, newFragment, newFragmentTag);
        transaction.addToBackStack(currentFragmentTag);
        transaction.commit();
    }

    public static void replaceFragment(int container, String newFragmentTag, Fragment newFragment, FragmentManager fragmentManager)
    {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(container, newFragment, newFragmentTag);
        transaction.commit();
    }

    public static void removeFragment(Fragment fragment, FragmentManager fragmentManager)
    {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.remove(fragment);
        transaction.commit();
    }

    public static <T extends Fragment> T getFragment(Class<T> type, FragmentManager fragmentManager, String tag)
    {
        return type.cast(fragmentManager.findFragmentByTag(tag));
    }
}
