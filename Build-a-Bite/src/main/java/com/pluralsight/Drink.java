package com.pluralsight;

import java.util.Scanner;

public class Drink {
    private String size;

    public Drink(Scanner scanner) {
        System.out.println("Select drink size (Small/Medium/Large):");
        this.size = scanner.nextLine();
    }

    public double getPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0;
        };
    }
    public String getSize() {
        return size;
    }
}

