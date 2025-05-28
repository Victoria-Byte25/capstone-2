package com.pluralsight;

import java.util.Scanner;

public class OrderManager {
    private static Scanner scanner = new Scanner(System.in);

    public static void startOrder(Order order) {
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n What would you like today?");
            System.out.println("1) Add a Sandwich");
            System.out.println("2) Add a Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addSandwich(order);
                    break;
                case "2":
                    addDrink(order);
                    break;
                case "3":
                    addChips(order);
                    break;
                case "4":
                    checkout(order);
                    ordering = false;
                    break;
                case "0":
                default:
                    System.out.println("Option not valid. Please try again.");
            }
        }

    }

    private static void addSandwich(Order order) {
        CustomSandwich sandwich = new CustomSandwich();
        sandwich.buildSandwich();
        order.addSandwich(sandwich);
        System.out.println("Sand added! ");

    }

    private static void addDrink(Order order) {
        System.out.println("What flavor of drink would you like today? (Coke, Fanta, Lemonade, etc.): ");
        String flavor = scanner.nextLine();

        System.out.println("Choose a size (Small, Medium, Large): ");
        String size = scanner.nextLine();

        Drink drink = new Drink(flavor, size);
        Order.addDrink(drink);
        System.out.println("Drink added!");

    }

    private static void addChips (Order order) {
        System.out.println("Enter chip type (Doritos, Cheetos, Lays, Ruffles, etc.): ");
        String chipType = scanner.nextLine();

        Chip chip = new Chip(chipType);
        order.addChip(chip);
        System.out.println("Chips added!");
    }

    private static void checkout(Order order) {
        System.out.println("Order Summary:");
        order.printOrder();

        System.out.println("\nConfirm and save receipt? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            ReceiptWriter.writeReceipt(order);
            System.out.println("Receipt saved. Thank you!");
        } else {
            System.out.println("Checkout canceled. Main menu.");
        }
    }
}