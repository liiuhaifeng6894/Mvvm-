package com.example.mvvmdemo2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.databinding.ItemNewsBinding;
import com.example.mvvmdemo2.bean.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<News> newsList;
//    private OnItemClickListener mOnItemClickListener = null;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemNewsBinding mItemNewsBinding;

        public ViewHolder(ItemNewsBinding itemNewsBinding) {
            super(itemNewsBinding.getRoot());
            this.mItemNewsBinding = itemNewsBinding;
        }
    }

    public NewsAdapter(Context mContext, List<News> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;
    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemNewsBinding itemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_news, viewGroup, false);
        // View view = LayoutInflater.from(mContext).inflate(R.layout.item_news, viewGroup, false);
        return new ViewHolder(itemNewsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        ViewHolder mViewHolder = (ViewHolder) viewHolder;
        // dataBinding绑定
        News news = newsList.get(position);
        mViewHolder.mItemNewsBinding.setNews(news);
        // 直接在adapter里设置点击事件
        mViewHolder.mItemNewsBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String newsUrlPrefix = mContext.getResources().getString(R.string.news_url_prefix);
//                String httpUrl = newsUrlPrefix + newsList.get(position).getItem_id();
//                Intent intent = new Intent(mContext, WebViewActivity.class);
//                intent.putExtra("httpUrl", httpUrl);
//                mContext.startActivity(intent);
            }
        });
        mViewHolder.mItemNewsBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
