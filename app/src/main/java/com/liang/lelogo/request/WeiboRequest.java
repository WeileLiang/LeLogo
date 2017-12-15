package com.liang.lelogo.request;

import com.liang.lelogo.constant.URLs;
import com.liang.lelogo.response.HomeTimeLineResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ASUS on 2017/11/11.
 */

public class WeiboRequest {

    public static void sendHomeTimeLineRequest(final SimpleCallback<HomeTimeLineResponse> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                //注意这里是请求的主机名
                .baseUrl(URLs.BASE_URL)
                .build();


        WeiboApi api = retrofit.create(WeiboApi.class);
        Call<HomeTimeLineResponse> call = api.getHomeTimeLine("2.00LdVtfC9xhcEE35946afbbawzZ_XB");
        call.enqueue(new Callback<HomeTimeLineResponse>() {
            @Override
            public void onResponse(Call<HomeTimeLineResponse> call, Response<HomeTimeLineResponse> response) {
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<HomeTimeLineResponse> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });

    }


}
