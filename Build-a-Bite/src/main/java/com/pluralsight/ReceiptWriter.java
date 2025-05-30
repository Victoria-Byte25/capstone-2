package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void writeReceipt(Order order) {
        try {
            File dir = new File("receipts");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String filename = "receipts/" + timestamp + ".txt";

            FileWriter writer = new FileWriter(filename);
            writer.write("---Build-a-Bite Sandwich Receipt---\n");
            writer.write("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("-----------------------------------\n\n");

            double total = 0;
            int count = 1;

            for (Sandwich s : order.getSandwiches()) {
                writer.write("Sandwich " + count + ": " + s.getDetails() + "\n");

                if (s instanceof CustomSandwich cs) {
                    writer.write("  Meats:     " + cs.getMeatsString() + "\n");
                    writer.write("  Cheeses:   " + cs.getCheesesString() + "\n");
                    writer.write("  Toppings:  " + cs.getRegularsString() + "\n");
                    writer.write("  Sauces:    " + cs.getSaucesString() + "\n");
                }

                double price = s.getPrice();
                total += price;
                writer.write("  Price:    $" + String.format("%.2f", price) + "\n\n");
                count++;
            }

            for (Drink d : order.getDrinks()) {
                double price = d.getPrice();
                writer.write("Drink (" + d.getSize() + "): $" + String.format("%.2f", price) + "\n");
                total += price;
            }

            for (Chip c : order.getChips()) {
                double price = c.getPrice();
                writer.write("Chips (" + c.getType() + "): $" + String.format("%.2f", price) + "\n");
                total += price;
            }

            writer.write("\n-----------------------------------\n");
            writer.write("TOTAL: $" + String.format("%.2f", total) + "\n");
            writer.write("Thanks for Biting!\n");

            writer.close();
            System.out.println("Receipt saved to: " + filename);

        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}
