package com.pluralsight;

public enum SandwichSize {
    SMALL_4(5.50),
    MEDIUM_8(7.00),
    LARGE_12(8.50);

    private double basePrice;

    SandwichSize(double price) {
        this.basePrice = price;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return name().replace("_", " ").replace("4", "4\"").replace("8", "8\"").replace("12", "12\"");
    }
}

