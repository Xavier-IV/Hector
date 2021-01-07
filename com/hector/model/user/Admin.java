package com.hector.model.user;

public class Admin extends User {
    protected String password;

    public Admin(String name, String phoneNum) {
        super(name, phoneNum);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
