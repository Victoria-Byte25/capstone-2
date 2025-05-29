package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void writeReceipt(Order order) {
        String filename = "receipts/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            for (Sandwich s : order.getSandwiches()) writer.write("Sandwich: " + s.getDetails() + "\n");
            for (Drink d : order.getDrinks()) writer.write("Drink: $" + d.getPrice() + "\n");
            for (Chip c : order.getChips()) writer.write("Chips: $" + c.getPrice() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing receipt.");
        }
    }
}
