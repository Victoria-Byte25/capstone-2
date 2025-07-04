package com.pluralsight;

public class Chip {
    private String type;

    public Chip(String type) {
        this.type = type;
    }

    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return type + "Chips ($" + String.format("%.2f", getPrice()) + ")";
    }
}
