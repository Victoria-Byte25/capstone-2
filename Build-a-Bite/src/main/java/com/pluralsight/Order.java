package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
    }
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }
    public void addChip(Chip chip) {
        chips.add(chip);
    }
    public void printOrder() {
        System.out.println("\n---- SANDWICHES---");
        for (int i = 0; i < sandwiches.size(); i++) {
            System.out.println("Sandwich" + (i + 1) + ":");
            System.out.println(sandwiches.get(i));
        }

        System.out.println("\n----DRINKS----");
        for (Drink drink : drinks) {
            System.out.println(drink);
            System.out.println("\n----CHIPS----");
            System.out.println(chip);
        }
        System.out.printf("\n Total Price: $%.2f\n", getSubtotal());
        System.out.println("Tax (5%%): $%.2f\n", getTax());
        System.out.println(" Final Total: $%.2f\n", getFinalTotal());
    }
    public double getSubtotal() {
        double total = 0.0;
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice
        }
        for (Chip chip : chips) {
            total += chip.getPrice();
        }
        return total;
    }
    public double getTax() {
        return getSubtotal() * Tax_RATE;
    }
    public double getFinalTotal() {
        return getSubtotal() + getTax();
    }
}
