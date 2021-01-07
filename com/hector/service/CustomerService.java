package com.hector.service;

import com.hector.model.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {

    public static void main(String[] args) throws IOException {

        ArrayList<Customer> customers = readCustomerFromFile();
        System.out.println(customers);
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        String name = input.nextLine();
        System.out.print("Enter Your Phone Number: ");
        String phoneNum = input.nextLine();
        System.out.print("Enter Your Status: ");
        Customer.CustomerStatus status = Customer.CustomerStatus.valueOf(input.nextLine());   // read away unwanted newline.
        customers.add(new Customer(name, phoneNum, status));
        System.out.println(customers);
        System.out.println();

        System.out.println("Save customers to file...");
        saveCustomerToFile(customers);

        // com.hector.model.Customer c = new com.hector.model.Customer();
        // com.hector.model.Shop s = new com.hector.model.Shop();
        // Admin add = new Admin();

    }

    private static ArrayList<Customer> readCustomerFromFile() throws IOException {
        ArrayList<Customer> customers = new ArrayList<>();

        // read customer.csv into a list of lines.
        List<String> lines = Files.readAllLines(Paths.get("customers.csv"));
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma
            String[] items = lines.get(i).split(",");
            // items[0] is name, items[1] is phoneNum, items[2] is status
            customers.add(new Customer(items[0], items[1], Customer.CustomerStatus.valueOf(items[2])));
        }
        return customers;
    }

    private static void saveCustomerToFile(ArrayList<Customer> customers) throws IOException {
        // read customers.csv into a list of lines.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customers.size(); i++) {
            sb.append(customers.get(i).toString() + "\n");
        }
        Files.write(Paths.get("customers.csv"), sb.toString().getBytes());
    }

}
