package com.pluralsight;

import java.util.*;

public class MenuHelper {
    public static String chooseFromList(Scanner scanner, List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
        int choice = Integer.parseInt(scanner.nextLine());
        return options.get(choice - 1);
    }

    public static List<Topping> multiSelect(Scanner scanner, List<String> options, ToppingType type) {
        List<Topping> selected = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
        System.out.println("Enter numbers (comma separated):");
        String[] picks = scanner.nextLine().split(",");
        for (String pick : picks) {
            int index = Integer.parseInt(pick.trim()) - 1;
            if (index >= 0 && index < options.size()) {
                selected.add(new Topping(options.get(index), type));
            }
        }
        return selected;
    }

    public static List<String> getBreadOptions() {
        return List.of("White", "Wheat", "Rye", "Wrap");
    }

    public static List<String> getMeatOptions() {
        return List.of("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon");
    }

    public static List<String> getCheeseOptions() {
        return List.of("American", "Provolone", "Cheddar", "Swiss");
    }

    public static List<String> getRegularToppings() {
        return List.of("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms");
    }

    public static List<String> getSauces() {
        return List.of("Mayo", "Mustard", "Ketchup", "Ranch", "Vinaigrette");
    }
}
