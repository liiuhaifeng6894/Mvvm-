package com.example.mvvmdemo2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.databinding.ActivityMain3Binding;
import com.example.mvvmdemo2.bean.Student;

public class Main3Activity extends AppCompatActivity {

    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ActivityMain3Binding activityMain3Binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);
        student = new Student("李四", "188000013");
        activityMain3Binding.setStudent(student);

        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                student.setName("雨驼");
                student.setPhoneNumber("110");
            }
        }, 4000);
    }
}
