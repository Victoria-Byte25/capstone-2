package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private SandwichSize size;
    private String breadType;
    private boolean toasted;
    private List<String> meats;
    private List<String> cheeses;
    private List<String> regualrToppings;
    private List<String> sauces;

    public Sandwich () {
        meats = new ArrayList<>();
        cheeses =new ArrayList<>();
        regualrToppings = new ArrayList<>();
        sauces = new ArrayList<>();
        toasted = false;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }
    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public void setMeats(String meat) {
        meats.add(meat);
    }
    public void addCheese(String cheese) {
        cheeses.add(cheese);
    }
    public void addTopping(String topping) {
        regualrToppings.add(topping);
    }
    public void addSauce(String sauce) {
        sauces.add(sauce);
    }
    public SandwichSize getSize() {
        return size;
    }

    public List<String> getMeats() {
        return meats;
    }

    public List<String> getCheeses() {
        return cheeses;
    }
    public double calculatePrice() {
        double price = size.getBasePrice();

        double meatPrice = switch (size) {
            case SMALL_4 -> 1.00;
            case MEDIUM_8 -> 2.00;
            case LARGE_12 -> 3.00;
        };

        double cheesePrice = switch (size) {
            case SMALL_4 -> 0.75;
            case MEDIUM_8 -> 1.50;
            case LARGE_12 -> 2.25;
        };
        price += meats.size() * meatPrice;
        price += cheeses.size() * cheesePrice;
        return price;
    }
    @Override
    public String toString() {
        return size + " " + breadType + (toasted ? "(Toasted)" : "") + "\n" +
                "Meats: " + meats + "\n" +
                "Cheeses: " + cheeses + "\n" +
                "Toppings: " + regualrToppings + "\n" +
                "Sauces: " + sauces + "\n" +
                String.format("Sandwich Price: $%.2f", calculatePrice());

    }
}
