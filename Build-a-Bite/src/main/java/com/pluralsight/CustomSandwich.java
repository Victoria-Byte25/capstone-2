package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class CustomSandwich extends Sandwich {
    private Scanner scanner = new Scanner(System.in);

    public void build() {
        System.out.println("Let’s build your sandwich! ");

        // === 1. Choose Size ===
        System.out.println("Choose your sandwich size:");
        System.out.println("1. Small (4\")\n2. Medium (8\")\n3. Large (12\")");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();
        setSize(switch (sizeChoice) {
            case 1 -> SandwichSize.SMALL_4;
            case 2 -> SandwichSize.MEDIUM_8;
            default -> SandwichSize.LARGE_12;
        });

        // === 2. Bread Type ===
        List<String> breads = List.of("White", "Wheat", "Sourdough", "Rye");
        System.out.println("Pick a bread type:");
        for (int i = 0; i < breads.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, breads.get(i));
        }
        int breadChoice = scanner.nextInt();
        scanner.nextLine();
        if (breadChoice >= 1 && breadChoice <= breads.size()) {
            setBreadType(breads.get(breadChoice - 1));
        } else {
            setBreadType("White");
        }

        // === 3. Toasted? ===
        System.out.println("Would you like it toasted? (yes/no)");
        String toasted = scanner.nextLine();
        setToasted(toasted.equalsIgnoreCase("yes"));

        // === 4. Meats ===
        List<String> meats = List.of("Turkey", "Ham", "Beef", "Salami", "Chicken");
        System.out.println("Choose meats (type 0 to finish):");
        while (true) {
            for (int i = 0; i < meats.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, meats.get(i));
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice >= 1 && choice <= meats.size()) {
                addMeat(meats.get(choice - 1));
            }
        }

        // === 5. Cheeses ===
        List<String> cheeses = List.of("American", "Swiss", "Cheddar", "Provolone");
        System.out.println("Choose cheeses (type 0 to finish):");
        while (true) {
            for (int i = 0; i < cheeses.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, cheeses.get(i));
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice >= 1 && choice <= cheeses.size()) {
                addCheese(cheeses.get(choice - 1));
            }
        }

        // === 6. Sauces ===
        List<String> sauces = List.of("Mayo", "Mustard", "BBQ", "Ranch", "Vinaigrette");
        System.out.println("Choose sauces (type 0 to finish):");
        while (true) {
            for (int i = 0; i < sauces.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, sauces.get(i));
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice >= 1 && choice <= sauces.size()) {
                addSauce(sauces.get(choice - 1));
            }
        }

        // === 7. Regular Toppings ===
        List<String> regularToppings = List.of("Lettuce", "Tomato", "Pickles", "Cucumber");
        System.out.println("Choose regular toppings (type 0 to finish):");
        while (true) {
            for (int i = 0; i < regularToppings.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, regularToppings.get(i));
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice >= 1 && choice <= regularToppings.size()) {
                addTopping(regularToppings.get(choice - 1), false);
            }
        }

        // === 8. Premium Toppings ===
        List<String> premiumToppings = List.of("Avocado", "Bacon", "Fried Egg");
        System.out.println("Choose premium toppings ($1.00 each, type 0 to finish):");
        while (true) {
            for (int i = 0; i < premiumToppings.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, premiumToppings.get(i));
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice >= 1 && choice <= premiumToppings.size()) {
                addTopping(premiumToppings.get(choice - 1), true);
            }
        }

        System.out.println("\n Your sandwich is ready!");
    }
}
