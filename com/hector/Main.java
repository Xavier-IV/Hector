package com.hector;

import com.hector.database.DataFactory;
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

        DataFactory.init(customerList, shopList, visitList, visitHistoryService);

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


}
