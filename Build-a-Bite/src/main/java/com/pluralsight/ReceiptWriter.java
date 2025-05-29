package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class ReceiptWriter {
    private static final double TAX_RATE = 0.0825;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void writeReceipt(Order order) {
        Sandwich sandwich = order.getSandwich();
        if (sandwich != null) {
            printReceipt(sandwich, 0.0, false, false);
            exportToFile(sandwich, 0.0, false, false);
        } else {
            System.out.println("No sandwich found in the order.");
        }
    }

    public static void printReceipt(Sandwich sandwich, double extrasTotal, boolean chips, boolean drink) {
        System.out.println("\n Your Receipt:");
        System.out.println("-------------------------");
        System.out.println(sandwich);

        System.out.println("Premium Toppings:");
        for (Topping t : sandwich.getToppings()) {
            if (t.isPremium()) {
                System.out.printf("- %s: $1.00\n", t.getName());
            }
        }

        if (chips) System.out.println("Chips: $1.50");
        if (drink) System.out.println("Drink: $2.00");

        double subtotal = sandwich.calculatePrice() + extrasTotal;
        double tax = subtotal * TAX_RATE;
        double total = subtotal + tax;

        System.out.println("-------------------------");
        System.out.println("Subtotal: $" + df.format(subtotal));
        System.out.println("Tax (8.25%): $" + df.format(tax));
        System.out.println("Total: $" + df.format(total));
        System.out.println("-------------------------");
        System.out.println("Thanks for choosing Build-a-Bite");
    }

    // ✨ New: Export to file
    public static void exportToFile(Sandwich sandwich, double extrasTotal, boolean chips, boolean drink) {
        LocalDateTime now = LocalDateTime.now();
        String fileName = "receipt-" + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm")) + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Build-a-Bite Order Receipt\n");
            writer.write("-------------------------\n");
            writer.write(sandwich.toString() + "\n");

            writer.write("Premium Toppings:\n");
            for (Topping t : sandwich.getToppings()) {
                if (t.isPremium()) {
                    writer.write("- " + t.getName() + ": $1.00\n");
                }
            }

            if (chips) writer.write("Chips: $1.50\n");
            if (drink) writer.write("Drink: $2.00\n");

            double subtotal = sandwich.calculatePrice() + extrasTotal;
            double tax = subtotal * TAX_RATE;
            double total = subtotal + tax;

            writer.write("-------------------------\n");
            writer.write("Subtotal: $" + df.format(subtotal) + "\n");
            writer.write("Tax (8.25%): $" + df.format(tax) + "\n");
            writer.write("Total: $" + df.format(total) + "\n");
            writer.write("-------------------------\n");
            writer.write("Thank you for choosing Build-a-Bite \n");

            System.out.println("Receipt saved as: " + fileName);
        } catch (IOException e) {
            System.out.println(" Error saving receipt: " + e.getMessage());
        }
    }
}
