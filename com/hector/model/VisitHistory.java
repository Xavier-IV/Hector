package com.hector.model;

import com.hector.model.user.Customer;

import java.time.LocalDateTime;

public class VisitHistory {

    private LocalDateTime localDateTime;
    private Customer customer;
    private Shop shop;

    public VisitHistory() {}

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Customer getCustomer() { return this.customer; }
    public Shop getShop() { return this.shop; }
    public LocalDateTime getLocalDateTime() { return this.localDateTime; }

    public VisitHistory checkIn() {
        LocalDateTime now = LocalDateTime.now();
        this.localDateTime = now;
        return this;
    }
}
