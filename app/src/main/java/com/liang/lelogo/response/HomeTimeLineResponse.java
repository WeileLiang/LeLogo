package com.liang.lelogo.response;

import com.liang.lelogo.entity.WeiboContent;

import java.util.List;

/**
 * Created by ASUS on 2017/11/8.
 */

public class HomeTimeLineResponse {

    private List<WeiboContent> statuses;

    public List<WeiboContent> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<WeiboContent> statuses) {
        this.statuses = statuses;
    }
}
