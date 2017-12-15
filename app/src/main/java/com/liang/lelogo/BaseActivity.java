package com.liang.lelogo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by ASUS on 2017/10/22.
 */

public class BaseActivity extends AppCompatActivity{

    protected String TAG;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        TAG=getClass().getSimpleName();
        ButterKnife.bind(this);
    }

    protected void intent2Activity(Class<? extends Activity> activity){
        startActivity(new Intent(this, activity));
    }

}
