package com.liang.lelogo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liang.lelogo.R;
import com.liang.lelogo.entity.WeiboContent;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ASUS on 2017/11/12.
 */

public class StatusAdapter extends RecyclerView.Adapter {
    public List<String> datas = Arrays.asList("1", "2", "3", "4", "5", "6");

    private List<WeiboContent> status;

    public StatusAdapter(List<WeiboContent> status) {
        this.status = status;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_status, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tv_name.setText(status.get(position).getUser().getScreen_name());
        viewHolder.tv_time.setText(status.get(position).getCreated_at());
        viewHolder.tv_text.setText(status.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return status.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView tv_name;

        @BindView(R.id.tv_time)
        TextView tv_time;

        //微博正文
        @BindView(R.id.tv_text)
        TextView tv_text;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
