package com.example.mvvmdemo.viewmodel;

import com.example.mvvmdemo.other.LoadListener;
import com.example.mvvmdemo2.view.MainActivity;
import com.example.mvvmdemo.model.Feed;
import com.example.mvvmdemo2.bean.News;

import java.util.List;

public class MainViewModel {
    private MainActivity mActivity;
    private String feedUrl;

    public MainViewModel(MainActivity activity) {
        mActivity = activity;
    }

    public void loadNews() {
//        // 获取url
//        // 加载数据
//        Feed feed = new Feed();
//        feed.loadData("https://www.toutiao.com/api/pc/feed/", new LoadListener<News>() {
//            @Override
//            public void loadSuccess(List<News> list) {
//                // 加载数据成功
//                mActivity.mNewsList.addAll(list);
//                mActivity.mNewsAdapter.notifyDataSetChanged();
//            }
//            @Override
//            public void loadFailure(String message) {
//                // 加载数据失败
//            }
//        });

        for (int j = 0; j < 10; j++) {
            mActivity.mNewsList.add(new News("android", String.valueOf(j), "中公" + j));
        }
        mActivity.mNewsAdapter.notifyDataSetChanged();
    }
}
