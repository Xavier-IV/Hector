package com.hector.service;

import com.hector.helper.Printer;
import com.hector.model.user.Customer;

import java.util.HashMap;
import java.util.Scanner;

public class CustomerService {
    Scanner option = new Scanner(System.in);
    HashMap<String, Customer> customerList;

    public CustomerService(HashMap<String, Customer> customerList) {
        this.customerList = customerList;
    }

    public void init() {
        Printer.CustomerMenu();

        int custOption = this.option.nextInt();

        switch (custOption) {
            case 2:
                login();
                break;
        }

    }

    public Boolean login() {
        String username, password;

        Printer.SignIn();
        System.out.print("username: ");
        username = this.option.next();
        System.out.print("password: ");
        password = this.option.next();

        Customer attemptLogin = this.customerList.get(username);
        Boolean loggedIn = attemptLogin.validatePassword(password);

        if (!loggedIn) {
            System.out.println("Wrong account credentials");
            return false;
        }
        return true;
    }
}
