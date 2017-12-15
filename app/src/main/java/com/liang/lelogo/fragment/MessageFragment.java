package com.liang.lelogo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liang.lelogo.BaseFragment;
import com.liang.lelogo.R;

/**
 * Created by ASUS on 2017/11/2.
 */

public class MessageFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_msg,null);

        return view;
    }
}
