package com.example.mvvmdemo.other;

import com.example.mvvmdemo.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface INews {
    @GET(".")
    Call<Feed> getFeed();
}
