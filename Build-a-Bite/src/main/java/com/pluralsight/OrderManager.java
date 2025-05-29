package com.pluralsight;

import java.util.Scanner;

public class OrderManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static void startOrder(Order order) {
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n========= Build-a-Bite Menu =========");
            System.out.println("1. Build a Custom Sandwich");
            System.out.println("2. Choose a Signature Sandwich");
            System.out.println("3. Checkout & Save Receipt");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addCustomSandwich(order);
                case 2 -> addSignatureSandwich(order);
                case 3 -> checkout(order);
                case 0 -> {
                    System.out.println("Goodbye!");
                    ordering = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addCustomSandwich(Order order) {
        CustomSandwich sandwich = new CustomSandwich();
        sandwich.build();
        order.addSandwich(sandwich);
        System.out.println("Custom sandwich added!");
    }

    private static void addSignatureSandwich(Order order) {
        System.out.println("Choose a Signature Sandwich:");
        System.out.println("1. BLT\n2. Philly\n3. Veggie Deluxe");
        System.out.print("Your choice: ");
        String choice = scanner.nextLine();

        SignatureSandwich signature = new SignatureSandwich(choice);
        order.addSandwich(signature);
        System.out.println(" " + choice.toUpperCase() + " added to your order!");
    }

    private static void checkout(Order order) {
        System.out.println("\n Order Summary:");
        order.printOrder();

        // === Ask for extras ===
        boolean chips = false;
        boolean drink = false;
        double extrasTotal = 0.0;

        System.out.print("\nWould you like chips for $1.50? (yes/no): ");
        String chipChoice = scanner.nextLine();
        if (chipChoice.equalsIgnoreCase("yes")) {
            chips = true;
            extrasTotal += 1.50;
        }

        System.out.print("Would you like a drink for $2.00? (yes/no): ");
        String drinkChoice = scanner.nextLine();
        if (drinkChoice.equalsIgnoreCase("yes")) {
            drink = true;
            extrasTotal += 2.00;
        }

        // === Confirm & save ===
        System.out.print("\nConfirm and save receipt? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            Sandwich sandwich = order.getSandwich();
            if (sandwich != null) {
                ReceiptWriter.printReceipt(sandwich, extrasTotal, chips, drink);
                ReceiptWriter.exportToFile(sandwich, extrasTotal, chips, drink);
                System.out.println(" Receipt saved. Thank you!");
            } else {
                System.out.println(" No sandwich found to save.");
            }
        } else {
            System.out.println(" Checkout canceled. Returning to menu.");
        }
    }
}
