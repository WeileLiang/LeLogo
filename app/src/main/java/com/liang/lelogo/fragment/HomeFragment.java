package com.liang.lelogo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liang.lelogo.BaseFragment;
import com.liang.lelogo.R;
import com.liang.lelogo.adapter.StatusAdapter;
import com.liang.lelogo.entity.WeiboContent;
import com.liang.lelogo.request.SimpleCallback;
import com.liang.lelogo.request.WeiboRequest;
import com.liang.lelogo.response.HomeTimeLineResponse;
import com.liang.lelogo.views.DividerDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by ASUS on 2017/11/2.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.rv_home_timeline)
    public RecyclerView mRv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder= ButterKnife.bind(this,view);

        mRv.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        mRv.setLayoutManager(layoutManager);
        mRv.addItemDecoration(new DividerDecoration(getActivity().getApplicationContext()));
        getHomeTimeLineResponse();
        return view;
    }

    //获取关注人发的微博
    private void getHomeTimeLineResponse() {
        WeiboRequest.sendHomeTimeLineRequest(new SimpleCallback<HomeTimeLineResponse>() {
            @Override
            public void onResponse(Call<HomeTimeLineResponse> call, Response<HomeTimeLineResponse> response) {
                super.onResponse(call, response);
                HomeTimeLineResponse homeTimeLine = response.body();
                List<WeiboContent> statuses = homeTimeLine.getStatuses();

                mRv.setAdapter(new StatusAdapter(statuses));

            }
        });
    }
}
