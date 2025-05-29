package com.pluralsight;

public class PriceCalculator {

    public static double calculate(Sandwich sandwich) {
        double basePrice = switch (sandwich.getSize()) {
            case SMALL_4 -> 5.00;
            case MEDIUM_8 -> 7.00;
            case LARGE_12 -> 8.50;
        };

        double toppingCost = 0.0;

        // Add premium topping charges
        for (Topping topping : sandwich.getToppings()) {
            toppingCost += topping.getPrice(); // $1.00 if premium
        }

        return basePrice + toppingCost;
    }

    public static double calculateWithTax(Sandwich sandwich, double taxRate) {
        double subtotal = calculate(sandwich);
        return subtotal + (subtotal * taxRate);
    }
}

