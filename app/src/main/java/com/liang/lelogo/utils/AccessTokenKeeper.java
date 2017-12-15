package com.liang.lelogo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;

/**
 * Created by ASUS on 2017/10/22.
 */

public class AccessTokenKeeper {

    public static final String SHARE_PREFERENCES_NAME="weibo_access_token";
    public static final String TOKEN="token";
    public static final String EXPIRES_TIME="expires_time";
    public static final String UID="uid";
    public static final String REFRESH_TOKEN="refresh_token";
    public static final String PHONE_NUM="phone_number";

    public static void writeAccessToken(Context context,Oauth2AccessToken token){

        if(token==null) return;

        SharedPreferences sp=context.getSharedPreferences(SHARE_PREFERENCES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(TOKEN,token.getToken());
        editor.putLong(EXPIRES_TIME,token.getExpiresTime());
        editor.putString(UID,token.getUid());
        editor.putString(REFRESH_TOKEN,token.getRefreshToken());
        editor.putString(PHONE_NUM,token.getPhoneNum());

        editor.commit();
    }

    public static Oauth2AccessToken readAccessToken(Context context){
        SharedPreferences sp=context.getSharedPreferences(SHARE_PREFERENCES_NAME,Context.MODE_PRIVATE);
        Oauth2AccessToken token=new Oauth2AccessToken();
        token.setExpiresIn(String.valueOf(sp.getLong(EXPIRES_TIME,0L)));
        token.setToken(sp.getString(TOKEN,""));
        token.setUid(sp.getString(UID,null));

        Log.d("lwl",token.getToken());
        return token;
    }
}
