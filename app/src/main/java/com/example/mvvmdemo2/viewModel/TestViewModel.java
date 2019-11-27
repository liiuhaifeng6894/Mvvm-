package com.example.mvvmdemo2.viewModel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.mvvmdemo2.bean.News;

import java.util.ArrayList;
import java.util.List;

public class TestViewModel extends ViewModel {

    private MutableLiveData<List<News>> mNameEvent = new MutableLiveData<>();
    private ArrayList<News> arrayList;

    public MutableLiveData<List<News>> getNameEvent() {
        return mNameEvent;
    }

    public void getContentData() {
        arrayList = new ArrayList<>();

        for (int j = 0; j < 10; j++) {
            arrayList.add(new News("android", String.valueOf(j), "中公" + j));
        }
        mNameEvent.setValue(arrayList);
    }


}
