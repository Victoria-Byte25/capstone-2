package com.pluralsight;

public class Topping {
    private final String name;
    private final ToppingType type;

    public Topping(String name, ToppingType type) {
        this.name = name;
        this.type = type;
    }

    public double getPrice(SandwichSize size) {
        if (type == ToppingType.MEAT) {
            return switch (size) {
                case FOUR -> 1.00;
                case EIGHT -> 2.00;
                case TWELVE -> 3.00;
            };
        }
        if (type == ToppingType.CHEESE) {
            return switch (size) {
                case FOUR -> 0.75;
                case EIGHT -> 1.50;
                case TWELVE -> 2.25;
            };
        }
        return 0;
    }

    public String getName() {
        return name;
    }
}

