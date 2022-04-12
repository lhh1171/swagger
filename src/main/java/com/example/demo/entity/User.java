package com.example.demo.entity;


/**
 * @author lqc
 */

public class User {

    String uid;
    String name;
    String password;

    public User(String uid, String name,String password) {
        this.uid = uid;
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
