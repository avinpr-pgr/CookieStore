package com.hacksu.CookieStore;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class FragmentHelper
{
    public static void showFragment(String currentFragmentTag, Fragment currentFragment, String newFragmentTag, Fragment newFragment, FragmentManager fragmentManager)
    {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_up, R.animator.slide_in_down, R.animator.slide_out_down);
        transaction.remove(currentFragment);
        transaction.add(R.id.pager, newFragment, newFragmentTag);
        transaction.addToBackStack(currentFragmentTag);
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
