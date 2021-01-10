package com.hector.helper;

public class Printer {
    public static void MainMenu() {
        System.out.println("");
        System.out.println("Choose role (Input number to choose)");
        System.out.println("");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.println("3. Shop");
        System.out.println("4. Exit");
    }

    public static void InvalidMenu() {
        System.out.println("");
        System.out.println("Invalid input");
        System.out.println("Perform another action? (Enter 1 if yes,any other number for no)");
    }

    public static void AdminMenu() {
        System.out.println("Which option do you want to choose? (Input number to choose)");
        System.out.println("1.Update Customer Status(Flagging)");
        System.out.println("2.View Customer history");
        System.out.println("3.View Shop Details");
    }

    public static void SignIn() {
        System.out.println("Please login");
    }

    public static void CustomerMenu() {
        System.out.println("Hello customer,what can we help you with? (Input number to choose)");
        System.out.println("1.Register");
        System.out.println("2.Check in");
        System.out.println("3.View history");
        System.out.println("4.View status");
        System.out.println("0.Main Menu");
    }
}
