package com.hector.model.user;

public class Customer extends User {
    private Customer.CustomerStatus status;

    public enum CustomerStatus {
        CLEAR,
        CASE,
        CONTACT
    }

    public Customer(String name, String phoneNum, CustomerStatus status) {
        super(name, phoneNum);
        this.status = status;
    }

    public Customer.CustomerStatus getStatus() {
        return status;
    }

    public void setCustomerStatus(Customer.CustomerStatus status) {
        this.status = status;
    }

    public String toString() {
        return "Name: " + getName() + "\nPhone Number: " + getPhoneNo() + "\nStatus: " + getStatus();
    }
}
