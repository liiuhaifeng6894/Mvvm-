package com.example.mvvmdemo2.bean;

public class User {

    public User(String name, String phoneNumbenr) {
        this.name = name;
        this.phoneNumbenr = phoneNumbenr;
    }

    public String name;
    public String phoneNumbenr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumbenr() {
        return phoneNumbenr;
    }

    public void setPhoneNumbenr(String phoneNumbenr) {
        this.phoneNumbenr = phoneNumbenr;
    }


}
