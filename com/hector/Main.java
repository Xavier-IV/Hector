package com.hector;

import com.hector.helper.Printer;
import com.hector.model.Shop;
import com.hector.model.VisitHistory;
import com.hector.model.user.Customer;
import com.hector.service.CustomerService;
import com.hector.service.VisitHistoryService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /* Master records */
        HashMap<String, Customer> customerList = new HashMap<String, Customer>();
        HashMap<String, Shop> shopList = new HashMap<String, Shop>();
        HashMap<Integer, VisitHistory> visitList = new HashMap<Integer, VisitHistory>();

        /* Services */
        VisitHistoryService visitHistoryService = new VisitHistoryService();

        Main.init(customerList, shopList);

        int role;
        Printer.MainMenu();

        Scanner option = new Scanner(System.in);

        do {
            role = option.nextInt();
            switch (role) {
                case 1:
                    Printer.AdminMenu();
                    break;
                case 2:
                    role = new CustomerService(customerList, shopList, visitList, visitHistoryService).init();
                    break;
                default:
                    Printer.MainMenu();
                    break;
            }

            System.out.println("");
        } while (role != 4);

    }

    public static void init(
            HashMap<String, Customer> customerList,
            HashMap<String, Shop> shopList) {
        /* Setup Customer */
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

        /* Setup shops */
        Shop shop1 = new Shop(
                "XA-00001",
                "Aqil Groceries",
                "01241231",
                Shop.ShopStatus.CLEAR,
                "Aqil");

        Shop shop2 = new Shop(
                "XA-00002",
                "Mobile Repair Sdn Bhd",
                "910413212",
                Shop.ShopStatus.CLEAR,
                "Sammy");

        shopList.put("XA-00001", shop1);
        shopList.put("XA-00002", shop2);
    }
}
