package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void writeReceipt(Order order) {
        LocalDateTime now = LocalDateTime.now();
        String filename = "receipt-" + now.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Build-a-Bite Order Receipt\n");
            writer.write("-----------------------------------\n");

            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write(sandwich.toString() + "\n\n");
            }

            for (Drink drink : order.getDrinks()) {
                writer.write(drink.toString() + "\n");
            }

            for (Chip chip : order.getChips()) {
                writer.write(chip.toString() + "\n");
            }

            writer.write("\n-----------------------------------\n");
            writer.write(String.format("Subtotal: $%.2f\n", order.getSubtotal()));
            writer.write(String.format("Tax (8%%): $%.2f\n", order.getTax()));
            writer.write(String.format("Total: $%.2f\n", order.getFinalTotal()));
            writer.write("\nThank you for Biting!\n");

        } catch (IOException exception) {
            System.out.println("Printing Error: " + exception.getMessage());
        }
    }
}
