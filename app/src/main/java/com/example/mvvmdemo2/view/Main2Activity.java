package com.example.mvvmdemo2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.databinding.DAge;
import com.example.mvvmdemo2.bean.User;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
        DAge da = DataBindingUtil.setContentView(this, R.layout.activity_main2);

//        User user = new User("张三", "152140624081");
//
//        da.setUser(user);
        da.name.setText("王二麻子");


    }


}
