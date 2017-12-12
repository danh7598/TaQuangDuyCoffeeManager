package com.tqd.duy.models;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by Danh on 12/10/2017.
 */

public class UserExample {
    private ArrayList<User> listUser;

    public UserExample(ArrayList<User> listUser) {
        this.listUser = listUser;
    }
    public void SetUserExample(){
        listUser.add(new User("danh7598@gmail.com","danhiuy123"));
    }
}
