package com.liang.lelogo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.liang.lelogo.BaseActivity;
import com.liang.lelogo.R;
import com.liang.lelogo.utils.AccessTokenKeeper;

public class SplashActivity extends BaseActivity {


    public static final int WHAT_TO_LOGIN = 1;
    public static final int WHAT_TO_MAIN = 2;

    public static final int TIME_WAIT = 500;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case WHAT_TO_LOGIN:
                    intent2Activity(LoginActivity.class);
                    break;
                case WHAT_TO_MAIN:
                    intent2Activity(MainActivity.class);

                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (AccessTokenKeeper.readAccessToken(this).isSessionValid())
            handler.sendEmptyMessageDelayed(WHAT_TO_MAIN, TIME_WAIT);
        else
            handler.sendEmptyMessageDelayed(WHAT_TO_LOGIN, TIME_WAIT);
    }


}
