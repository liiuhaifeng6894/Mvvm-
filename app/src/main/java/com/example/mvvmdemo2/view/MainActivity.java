package com.example.mvvmdemo2.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.databinding.ActivityMainBinding;
import com.example.mvvmdemo2.bean.News;
import com.example.mvvmdemo2.adapter.NewsAdapter;
import com.example.mvvmdemo.viewmodel.MainViewModel;
import com.example.mvvmdemo2.viewModel.TestViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public ActivityMainBinding mActivityMainBinding;
    private MainViewModel mViewModel;

    public NewsAdapter mNewsAdapter;
    public List<News> mNewsList = new ArrayList<>();
    private TestViewModel mTestViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置dataBinding、viewModel
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        mViewModel = new MainViewModel(this);
//        mActivityMainBinding.setViewModel(mViewModel);
        // 初始化RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mActivityMainBinding.recyclerView.setLayoutManager(layoutManager);
        mNewsAdapter = new NewsAdapter(this, mNewsList);
        mActivityMainBinding.recyclerView.setAdapter(mNewsAdapter);
//        // 加载数据
//        mViewModel.loadNews();


        mTestViewModel = ViewModelProviders.of(this).get(TestViewModel.class);


        MutableLiveData<List<News>> nameEvent = mTestViewModel.getNameEvent();


        //监听content属性变化，只要触发了setValue/postValue方法就会走
        nameEvent.observe(this, new Observer<List<News>>() {
            @Override
            public void onChanged(@Nullable List<News> iNews) {
                mNewsList.addAll(iNews);
                mNewsAdapter.notifyDataSetChanged();
            }
        });


        mActivityMainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTestViewModel.getContentData();
            }
        });

    }
}
