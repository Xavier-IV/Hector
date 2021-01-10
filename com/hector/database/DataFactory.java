package com.hector.database;

import com.hector.model.Shop;
import com.hector.model.VisitHistory;
import com.hector.model.user.Customer;
import com.hector.service.VisitHistoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DataFactory {
    public static void init(
            HashMap<String, Customer> customerList,
            HashMap<String, Shop> shopList,
            HashMap<Integer, VisitHistory> visitList,
            VisitHistoryService visitHistoryService) {
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

        Shop shop3 = new Shop(
                "XA-00003",
                "99 Speedmart",
                "031941923",
                Shop.ShopStatus.CLEAR,
                "Abu");

        Shop shop4 = new Shop(
                "XA-00004",
                "Roswell",
                "09413121",
                Shop.ShopStatus.CLEAR,
                "Khairul");

        shopList.put("XA-00001", shop1);
        shopList.put("XA-00002", shop2);
        shopList.put("XA-00003", shop3);
        shopList.put("XA-00004", shop4);

        VisitHistory newVisit = new VisitHistory();
        newVisit.setCustomer(customer2);
        newVisit.setShop(shop3);
        VisitHistory record = newVisit.checkIn();

        visitList.put(visitHistoryService.nextVal(), record);
    }

    public static void randomizeRecords(
            HashMap<String, Customer> customerList,
            HashMap<String, Shop> shopList,
            HashMap<Integer, VisitHistory> visitList,
            VisitHistoryService visitHistoryService
    ) {
        /* Customer emails */
        ArrayList<String> emails = new ArrayList<>();
        emails.add("salman@gmail.com");
        emails.add("abi@gmail.com");

        ArrayList<String> registrationCodes = new ArrayList<>();
        registrationCodes.add("XA-00001");
        registrationCodes.add("XA-00002");
        registrationCodes.add("XA-00003");
        registrationCodes.add("XA-00004");

        /* Simulate random visit */
        for (int i = 0; i <= 30; i++) {
            int rand = getRandomNumber(0, 1);
            System.out.println(rand);
            String currEmail = emails.get(rand);
            Customer customer = customerList.get(currEmail);

            String currRegCode = registrationCodes.get(getRandomNumber(0, 3));
            Shop checkInShop = shopList.get(currRegCode);

            VisitHistory newVisit = new VisitHistory();
            newVisit.setCustomer(customer);
            newVisit.setShop(checkInShop);
            VisitHistory record = newVisit.checkIn();

            visitList.put(visitHistoryService.nextVal(), record);
        }
    }

    public static int getRandomNumber(int min, int max) {
        Random rand = new Random();
        int randnum = rand.nextInt(max);
        System.out.println(rand);

        return randnum;
    }
}
