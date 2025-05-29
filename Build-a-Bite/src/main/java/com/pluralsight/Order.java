package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chip> chips = new ArrayList<>();

    private static final double TAX_RATE = 0.0825;

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChip(Chip chip) {
        chips.add(chip);
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chip> getChips() {
        return chips;
    }

    public Sandwich getSandwich() {
        if (!sandwiches.isEmpty()) {
            return sandwiches.get(0);
        }
        return null;
    }

    public double getSubtotal() {
        double total = 0.0;

        for (Sandwich sandwich : sandwiches) {
            total += sandwich.calculatePrice();
        }

        for (Drink drink : drinks) {
            total += drink.getPrice();
        }

        for (Chip chip : chips) {
            total += chip.getPrice();
        }

        return total;
    }

    public double getTax() {
        return getSubtotal() * TAX_RATE;
    }

    public double getFinalTotal() {
        return getSubtotal() + getTax();
    }

    // === Print Summary ===
    public void printOrder() {
        System.out.println("\n---- SANDWICHES ----");
        for (int i = 0; i < sandwiches.size(); i++) {
            System.out.println("Sandwich " + (i + 1) + ":");
            System.out.println(sandwiches.get(i));
        }

        System.out.println("---- DRINKS ----");
        for (Drink drink : drinks) {
            System.out.println(drink);
        }

        System.out.println("---- CHIPS ----");
        for (Chip chip : chips) {
            System.out.println(chip);
        }

        System.out.printf("\nTotal Price: $%.2f\n", getSubtotal());
        System.out.printf("Tax (%.1f%%): $%.2f\n", TAX_RATE * 100, getTax());
        System.out.printf("Final Total: $%.2f\n", getFinalTotal());
    }
}
