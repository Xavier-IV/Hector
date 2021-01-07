package com.hector.model;

public class Customer {
    private String name;
    private String phoneNum;
    private CustomerStatus status;

    public enum CustomerStatus {
        CLEAR,
        CASE,
        CONTACT
    }

    public Customer(String name, String phoneNum, CustomerStatus status) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNum;
    }

    public void setPhoneNo(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setCustomerStatus(CustomerStatus status) {
        this.status = status;
    }

    public String toString() {
        return "Name: " + getName() + "\nPhone Number: " + getPhoneNo() + "\nStatus: " + getStatus();
    }
}
