package com.example.mvvmdemo2.bean;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;


public class Student extends BaseObservable {
    public Student(String name, String phoneNum) {
        this.name = name;
        this.phoneNumber = phoneNum;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyPropertyChanged(BR.phoneNumber);
    }

    public void onClickView(View view) {
        Toast.makeText(view.getContext(), "点击事件", Toast.LENGTH_LONG).show();

    }

    public String name;
    public String phoneNumber;
}
