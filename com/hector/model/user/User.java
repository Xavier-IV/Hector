package com.hector.model.user;

public class User {
    protected String name;
    protected String phoneNo;
    protected String password;

    public User(String name, String phoneNum) {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;

        if (object instanceof User)
        {
            sameSame = this.name == ((User) object).name;
        }

        return sameSame;
    }
}
