package com.pluralsight;

public class SignatureSandwich extends Sandwich {
    public SignatureSandwich(String name) {
        setToasted(true);
        setBreadType("White");

        switch (name.toLowerCase()) {
            case "blt" -> {
                setSize(SandwichSize.MEDIUM_8);
                addMeat("Bacon");
                addTopping("Lettuce", false);
                addTopping("Tomato", false);
                addSauce("Mayo");
            }
            case "philly" -> {
                setSize(SandwichSize.LARGE_12);
                setBreadType("Wheat");
                addMeat("Steak");
                addCheese("Provolone");
                addTopping("Peppers", false);
                addTopping("Onions", false);
            }
            case "veggie deluxe" -> {
                setSize(SandwichSize.SMALL_4);
                setToasted(false);
                addCheese("Swiss");
                addTopping("Lettuce", false);
                addTopping("Tomato", false);
                addTopping("Pickles",false);
                addTopping("Cucumbers", false);
                addSauce("Vinaigrette");
            }
            default -> {
                setSize(SandwichSize.MEDIUM_8);
                addTopping("Lettuce", false);
                addTopping("Tomato", false);
                addSauce("Mayo");
            }
        }
    }
}

