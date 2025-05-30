package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Sandwich> sandwiches = new ArrayList<>();
    private final List<Drink> drinks = new ArrayList<>();
    private final List<Chip> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChip(Chip chip) {
        chips.add(chip);
    }

    public void checkout() {
        double total = 0;
        for (Sandwich s : sandwiches) total += s.getPrice();
        for (Drink d : drinks) total += d.getPrice();
        for (Chip c : chips) total += c.getPrice();

        ReceiptWriter.writeReceipt(this);
        System.out.println("Order total: $" + String.format("%.2f", total));
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
}
