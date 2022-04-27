package com.example.demo.entity;


/**
 * @author lqc
 */

public class User {

    String tel;
    String name;
    String password;

    public User(String tel, String name, String password) {
        this.tel = tel;
        this.name = name;
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
