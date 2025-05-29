package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public abstract class Sandwich {
    private SandwichSize size;
    private String breadType;
    private boolean isToasted;

    private List<String> meats = new ArrayList<>();
    private List<String> cheeses = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();

    // Real topping support!
    private List<Topping> toppings = new ArrayList<>();

    // === Setters ===
    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    // === Ingredient ===
    public void addMeat(String meat) {
        meats.add(meat);
    }

    public void addCheese(String cheese) {
        cheeses.add(cheese);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    // Add toppings (regular or premium)
    public void addTopping(String name, boolean isPremium) {
        toppings.add(new Topping(name, isPremium));
    }

    // === Getters ===
    public SandwichSize getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    // === Pricing ===
    public double calculatePrice() {
        double price = switch (size) {
            case SMALL_4 -> 5.00;
            case MEDIUM_8 -> 7.00;
            case LARGE_12 -> 8.50;
        };

        for (Topping topping : toppings) {
            price += topping.getPrice(); // $1.00 if premium
        }

        return price;
    }

    // === Pretty display ===
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(size).append(" Sandwich on ").append(breadType);
        if (isToasted) sb.append(" (Toasted)");
        sb.append("\n");

        if (!meats.isEmpty()) sb.append("Meats: ").append(meats).append("\n");
        if (!cheeses.isEmpty()) sb.append("Cheeses: ").append(cheeses).append("\n");

        if (!toppings.isEmpty()) {
            sb.append("Toppings: ");
            for (Topping t : toppings) {
                sb.append(t.toString()).append(", ");
            }
            sb.setLength(sb.length() - 2); // remove last comma
            sb.append("\n");
        }

        if (!sauces.isEmpty()) sb.append("Sauces: ").append(sauces).append("\n");

        return sb.toString();
    }
}
