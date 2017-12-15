package com.liang.lelogo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import com.liang.lelogo.R;
import com.liang.lelogo.utils.FragmentHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    public FragmentHelper helper;
    @BindView(R.id.rg_tab)
    RadioGroup rgTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        helper = FragmentHelper.getInstance(this, R.id.fl_content);
        helper.showFragment(0);
        rgTab = (RadioGroup) findViewById(R.id.rg_tab);
        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        helper.showFragment(0);
                        break;
                    case R.id.rb_message:
                        helper.showFragment(1);
                        break;
                    case R.id.rb_search:
                        helper.showFragment(2);
                        break;
                    case R.id.rb_personal:
                        helper.showFragment(3);
                        break;

                }
            }
        });
    }


}
