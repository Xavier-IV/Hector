package com.hector;

import com.hector.model.user.Customer;
import com.hector.service.AuthService;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Zafranudin Zafrin",
                "0123141222",
                Customer.CustomerStatus.CLEAR);

        System.out.println(customer);
    }
}
