package com.liang.lelogo.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.liang.lelogo.fragment.HomeFragment;
import com.liang.lelogo.fragment.MessageFragment;
import com.liang.lelogo.fragment.PersonalFragment;
import com.liang.lelogo.fragment.SearchFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/11/2.
 */

public class FragmentHelper {
    private static FragmentHelper helper;

    private FragmentManager fm;
    private int containerId;

    private List<Fragment> fragments;

    private FragmentHelper(FragmentActivity context, int containerId) {
        fm = context.getSupportFragmentManager();
        this.containerId = containerId;
        initFragments();
    }

    public static FragmentHelper getInstance(FragmentActivity context, int containerId) {

        if (helper == null) {
            helper = new FragmentHelper(context, containerId);
        }

        return helper;
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new MessageFragment());
        fragments.add(new SearchFragment());
        fragments.add(new PersonalFragment());

        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragments) {
            ft.add(containerId, fragment);
        }

        ft.commit();
    }

    public void hideFragments() {
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragments) {
            ft.hide(fragment);
        }

        ft.commit();
    }

    public void showFragment(int position) {
        if (position >= fragments.size()||position<0) return;

        hideFragments();

        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragments.get(position));
        ft.commit();
    }

}
