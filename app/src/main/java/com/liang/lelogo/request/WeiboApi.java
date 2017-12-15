package com.liang.lelogo.request;

import com.liang.lelogo.constant.URLs;
import com.liang.lelogo.response.HomeTimeLineResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ASUS on 2017/11/10.
 */

public interface WeiboApi {

    @GET(URLs.HOME_TIMELINE)
    Call<HomeTimeLineResponse> getHomeTimeLine(@Query(URLs.ACCESS_TOKEN_PARAM) String accessToken);
}
