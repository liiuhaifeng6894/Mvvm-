package com.example.mvvmdemo.model;

import com.example.mvvmdemo.other.INews;
import com.example.mvvmdemo.other.LoadListener;
import com.example.mvvmdemo2.bean.News;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Feed {

    private boolean has_more;
    private String message;
    private List<News> data;

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(List<News> data) {
        this.data = data;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public String getMessage() {
        return message;
    }

    public List<News> getData() {
        return data;
    }

    // 通过传进来的url，利用retrofit获取网络数据，回调给viewModel
    public void loadData(String feedUrl, final LoadListener<News> loadListener) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(feedUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        INews iNews = retrofit.create(INews.class);
        Call<Feed> feed = iNews.getFeed();
        feed.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                // 获取成功
                loadListener.loadSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                // 获取失败
                loadListener.loadFailure(t.getMessage());
            }
        });
    }
}
