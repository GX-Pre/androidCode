package com.to.mynetchina;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    @BindView(R.id.recycler_view)
    ItheimaRecyclerView myRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mySwipRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<NewsBean>(mySwipRefreshLayout, myRecyclerView, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.item_list_news;
            }

            @Override
            public String getApi() {
                //接口
                return "action/apiv2/news?pageToken=";
            }
        };
        //开始请求
        pullToLoadMoreRecyclerView.requestData();
    }
    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<NewsBean.ResultDTO.ItemsDTO> {
        @BindView(R.id.tv_tile)
        TextView mTvTitle;
        @BindView(R.id.ll_title)
        LinearLayout mllTitle;
        @BindView(R.id.tv_description)
        TextView mTvdescription;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_commencement)
        TextView mTvcommence;
        @BindView(R.id.tv_countcommencement)
        TextView mTvcommencecount;
        public MyRecyclerViewHolder(ViewGroup parentView, int itemResId) {
            super(parentView, itemResId);
        }

        /**
         * 绑定数据的方法，在mData获取数据（mData声明在基类中）
         */
        @Override
        public void onBindRealData() {
            mTvTitle.setText(mData.title);
            mTvdescription.setText(mData.body);
            mTvTime.setText(mData.pubDate);
            mTvcommencecount.setText(mData.viewCount+"");

        }
    }
}