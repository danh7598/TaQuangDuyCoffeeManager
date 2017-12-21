package com.tqd.duy.models;

import java.util.ArrayList;

/**
 * Created by Danh on 12/10/2017.
 */

public class User {
    private String userName;
    private String userPassword;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public ArrayList<User> getSampleUser(){
        ArrayList<User> listUser = new ArrayList<>();
        listUser.add(new User("danh7598@gmail.com","danhiuy123"));
        return listUser;
    }
}
