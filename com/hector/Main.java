package com.hector;

import com.hector.helper.Printer;
import com.hector.model.user.Customer;
import com.hector.service.CustomerService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Customer> customerList = new HashMap<String, Customer>();
        Main.init(customerList);

        int role;
        Printer.MainMenu();

        Scanner option = new Scanner(System.in);
        role = option.nextInt();

        switch (role) {
            case 1:
                Printer.AdminMenu();
                break;
            case 2:
                new CustomerService(customerList).init();
                break;
            default:
                Printer.InvalidMenu();
                break;
        }
        System.out.println("");
    }

    public static void init(HashMap<String, Customer> customerList) {
        Customer customer1 = new Customer("Salman Halim",
                "01241231",
                Customer.CustomerStatus.CLEAR);
        customer1.setPassword("password123");

        Customer customer2 = new Customer("Abi Razi",
                "041313231",
                Customer.CustomerStatus.CLEAR);
        customer2.setPassword("password123");

        customerList.put("salman@gmail.com", customer1);
        customerList.put("abi@gmail.com", customer2);

    }
}
