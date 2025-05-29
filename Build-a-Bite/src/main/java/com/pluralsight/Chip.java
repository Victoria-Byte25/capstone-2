package com.pluralsight;

import java.util.Scanner;

public class Chip {
    private String type;

    public Chip(Scanner scanner) {
        System.out.println("Enter chip type:");
        this.type = scanner.nextLine();
    }

    public double getPrice() {
        return 1.50;
    }
}
