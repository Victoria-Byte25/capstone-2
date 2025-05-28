package com.pluralsight;

public class Drink {

    private String type;
    private String size;

    public Drink (String type, String size) {
        this.type = type;
        this.size = type;
    }
    public double getPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 1.50;
            case "medium" -> 2.00;
            case "large" -> 2.50;
            default -> 2.00;
        };
    }
    @Override
    public String toString() {
        return size + " " + type + " ($" + String.format("%.2f", getPrice()) + ")";
    }
}
