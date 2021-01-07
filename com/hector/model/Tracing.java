package com.hector.model;

import java.util.Scanner;
import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.ArrayList;

public class Tracing {
    public static void main(String[] args) {
        String customer, customerinfo;
        int role, action1, action2, shop, edit, status, action3, action4, check;
        int counter = 1;
        status = 0;

        List<String> customerList = new ArrayList<String>();
        List<String> historyList = new ArrayList<String>();
        customerList.add("Ali");
        customerList.add("Ahmad");
        customerList.add("Jason");
        customerList.add("Adam");
        customerList.add("Farah");

        while (counter == 1) {
            System.out.println("");
            System.out.println("Choose role (Input number to choose)");
            System.out.println("");
            System.out.println("1. Admin");
            System.out.println("2. com.hector.model.user.Customer");
            System.out.println("3. com.hector.model.Shop");
            System.out.println("4. Exit");
            Scanner option = new Scanner(System.in);
            role = option.nextInt();
            System.out.println("");
            switch (role) {
                case 1:
                    System.out.println("Which option do you want to choose? (Input number to choose)");
                    System.out.println("1.Update Customer Status(Flagging)");
                    System.out.println("2.View Customer history");
                    System.out.println("3.View Shop Details");
                    action1 = option.nextInt();
                    System.out.println("");
                    switch (action1) {
                        case 1:
                            System.out.println("Which customer you want to flag? (Input number to choose)");
                            for (int i = 0; i < customerList.size(); i++) {
                                System.out.println(customerList.get(i));
                            }
                            System.out.println("Input name, phone, status");
                            option.nextLine();
                            customerinfo = option.nextLine();
                            customerList.add(customerinfo);
                            System.out.println("Flagging Successful");
                            break;

                        case 2:
                            for (int i = 0; i < customerList.size(); i++) {
                                System.out.println(customerList.get(i));
                            }
                            break;
                        case 3:
                            System.out.println("View com.hector.model.Shop Details");
                            System.out.println("1.Dean Cafe");
                            System.out.println("2.Walmart");
                            System.out.println("3.Target");
                            System.out.println("4.Tesco");
                            action3 = option.nextInt();
                            System.out.println("");
                            switch (action3) {
                                case 1:
                                    System.out.println("Name      Phone      Manager  Status");
                                    System.out.println("Dean Cafe 0377665612 Mr.Jason Normal");
                                case 2:
                                    System.out.println("Name    Phone      Manager Status");
                                    System.out.println("Walmart 0322557890 Mr.Ng   Normal");
                                case 3:
                                    System.out.println("Name   Phone      Manager    Status");
                                    System.out.println("Target 0312568790 Ms.Rozanna Normal");
                                case 4:
                                    System.out.println("Name  Phone      Manager  Status");
                                    System.out.println("Tesco 0345678912 Mr.Smith Normal");
                                default:
                                    System.out.println("Invalid input");
                                    break;
                            }
                        default:
                            System.out.println("invalid input");
                            break;
                    }
                    System.out.println("");
                    System.out.println("Perform another action? (Enter 1 if yes,any other number for no)");
                    counter = option.nextInt();
                    break;
                case 2:
                    System.out.println("Hello customer,what can we help you with? (Input number to choose)");
                    System.out.println("1.Register");
                    System.out.println("2.Check in");
                    System.out.println("3.View history(com.hector.model.user.Customer");
                    action2 = option.nextInt();
                    System.out.println("");
                    switch (action2) {
                        case 1:
                            System.out.println("Which shop would you like to go? (Input number to choose)");
                            System.out.println("1.Dean Cafe");
                            System.out.println("2.Walmart");
                            System.out.println("3.Target");
                            System.out.println("4.Tesco");
                            shop = option.nextInt();
                            System.out.flush();
                            switch (shop) {
                                case 1:
                                    for (int i = 0; i < customerList.size(); i++) {
                                        System.out.println(customerList.get(i));
                                    }
                                    break;
                                case 2:
                                    for (int i = 0; i < customerList.size(); i++) {
                                        System.out.println(customerList.get(i));
                                    }
                                    break;
                                case 3:
                                    for (int i = 0; i < customerList.size(); i++) {
                                        System.out.println(customerList.get(i));
                                    }
                                    break;
                                case 4:
                                    for (int i = 0; i < customerList.size(); i++) {
                                        System.out.println(customerList.get(i));
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid input");
                                    break;
                            }
                            break;
                        case 2:
                            if (historyList.isEmpty()) {
                                System.out.println("No visit history available.");
                            } else {
                                System.out.println("View Visit History");
                                for (int i = 0; i < historyList.size(); i++)
                                    System.out.println(historyList.get(i));
                            }
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                    System.out.println("");
                    System.out.println("Perform another action? (Enter 1 if yes,any other number for no)");
                    counter = option.nextInt();
                    break;
                case 3:
                    System.out.println("View com.hector.model.Shop Details");
                    System.out.println("1.Dean Cafe");
                    System.out.println("2.Walmart");
                    System.out.println("3.Target");
                    System.out.println("4.Tesco");
                    action3 = option.nextInt();
                    System.out.println("");
                    switch (action3) {
                        case 1:
                            System.out.println("Name      Phone      Manager  Status");
                            System.out.println("Dean Cafe 0377665612 Mr.Jason Normal");
                        case 2:
                            System.out.println("Name    Phone      Manager Status");
                            System.out.println("Walmart 0322557890 Mr.Ng   Normal");
                        case 3:
                            System.out.println("Name   Phone      Manager    Status");
                            System.out.println("Target 0312568790 Ms.Rozanna Normal");
                        case 4:
                            System.out.println("Name  Phone      Manager  Status");
                            System.out.println("Tesco 0345678912 Mr.Smith Normal");
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                    System.out.println("");
                    System.out.println("Perform another action? (Enter 1 if yes,any other number for no)");
                    counter = option.nextInt();
                    break;
                case 4:
                    System.out.println("Thank you for using our Program");
                    System.out.println("");
                    System.out.println("Perform another action? (Enter 1 if yes,any other number for no)");
                    counter = option.nextInt();
                    break;
                default:
                    System.out.println("");
                    System.out.println("Invalid input");
                    System.out.println("Perform another action? (Enter 1 if yes,any other number for no)");
                    counter = option.nextInt();
                    break;
            }

        }
    }

}
		
		