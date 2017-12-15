package com.liang.lelogo;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import butterknife.Unbinder;

public class BaseFragment extends Fragment {

    protected Unbinder unbinder;


    protected void intent2Activity(Class<? extends Activity> target) {
        startActivity(new Intent(getActivity(), target));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) unbinder.unbind();
    }
}
