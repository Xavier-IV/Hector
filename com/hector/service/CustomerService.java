package com.hector.service;

import com.hector.helper.Printer;
import com.hector.model.Shop;
import com.hector.model.VisitHistory;
import com.hector.model.user.Customer;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class CustomerService {
    Scanner option = new Scanner(System.in);
    HashMap<String, Customer> customerList;
    HashMap<String, Shop> shopList;
    HashMap<Integer, VisitHistory> visitList;
    VisitHistoryService visitHistoryService;
    Customer loggedInUser;

    public CustomerService(
            HashMap<String, Customer> customerList,
            HashMap<String, Shop> shopList,
            HashMap<Integer, VisitHistory> visitList,
            VisitHistoryService visitHistoryService) {
        this.visitList = visitList;
        this.customerList = customerList;
        this.shopList = shopList;

        this.visitHistoryService = visitHistoryService;
    }

    public int init() {
        int custOption;

        do {
            System.out.println("\n\n\n");
            Printer.CustomerMenu();

            custOption = this.option.nextInt();

            switch (custOption) {
                case 1:
                    register();
                    break;
                case 3:
                    viewHistory();
                    break;
                case 4:
                    viewStatus();
                    break;
                default:
                case 2:
                    Boolean isLoggedIn = login();
                    checkIn();
                    System.out.println("User is loggedIn: " + isLoggedIn);
                    break;
            }
        } while (custOption != 0);

        return 0;
    }

    private void register() {
        String email, name, phoneNo, password;

        System.out.print("Email: ");
        email = this.option.next();
        System.out.print("Name: ");
        name = this.option.next();
        System.out.print("Phone No: ");
        phoneNo = this.option.next();
        System.out.print("Password: ");
        password = this.option.next();

        Customer newCustomer = new Customer(name,
                phoneNo,
                Customer.CustomerStatus.CLEAR);
        newCustomer.setPassword(password);

        customerList.put(email, newCustomer);
    }

    public Boolean login() {
        String username, password;

        if (!Objects.isNull(this.loggedInUser)) {
            return true;
        }

        Printer.SignIn();
        System.out.print("username: ");
        username = this.option.next();
        System.out.print("password: ");
        password = this.option.next();

        Customer attemptLogin = this.customerList.get(username);

        if (Objects.isNull(attemptLogin)) {
            System.out.println("Wrong account credentials");
            return false;
        }

        Boolean loggedIn = attemptLogin.validatePassword(password);

        if (!loggedIn) {
            System.out.println("Wrong account credentials");
            return false;
        }

        this.loggedInUser = attemptLogin;
        return true;
    }

    public void checkIn() {
        String registrationCode;

        System.out.println("Please choose a shop to check-in:");
        System.out.println(this.shopList);

        System.out.print("Shop Code: ");
        registrationCode = this.option.next();

        Shop checkInShop = this.shopList.get(registrationCode);

        if (Objects.isNull(checkInShop)) {
            System.out.println("Wrong shop information");
            return;
        }

        System.out.println("Shop Details");
        System.out.println(checkInShop);

        VisitHistory newVisit = new VisitHistory();
        newVisit.setCustomer(this.loggedInUser);
        newVisit.setShop(checkInShop);
        VisitHistory record = newVisit.checkIn();

        this.visitList.put(this.visitHistoryService.nextVal(), record);
    }

    public void viewHistory() {
        if (Objects.isNull(this.loggedInUser)) {
            System.out.print("You've not logged in yet.");
            this.login();
        }

        System.out.println("\n\nVisit History");
        System.out.println("Datetime" + "\t" + "Shop Name");
        for (VisitHistory history : this.visitList.values()) {
            if (history.getCustomer().getName().equals(this.loggedInUser.getName())) {
                System.out.println(
                        history.getCustomer().getName() + "\t" +
                                history.getLocalDateTime() + "\t" +
                                history.getShop().getShopname());
            }
        }
    }

    public void viewStatus() {
        if (Objects.isNull(this.loggedInUser)) {
            System.out.print("You've not logged in yet.");
            this.login();
        }
        System.out.println(this.loggedInUser.getStatus());
    }
}
