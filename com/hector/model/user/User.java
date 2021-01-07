package com.hector.model.user;

public class User {
    protected String name;
    protected String phoneNo;

    public User (String name, String phoneNum) {
        this.name = name;
        this.phoneNo = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNum) {
        this.phoneNo = phoneNum;
    }

}
