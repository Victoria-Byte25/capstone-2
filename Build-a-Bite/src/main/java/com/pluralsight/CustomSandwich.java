package com.pluralsight;

import java.util.Scanner;

public class CustomSandwich  extends Sandwich{
    public void buildSandwich() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your sandwich size:");
        System.out.println("1) 4-inch");
        System.out.println("2) 8-inch");
        System.out.println("3) 12-inch");
        System.out.println("Your choice is: ");
        int sizeChoice = Integer.parseInt(scanner.nextLine());

        switch (sizeChoice) {
            case 1 -> setSize(SandwichSize.SMALL_4);
            case 2 -> setSize(SandwichSize.MEDIUM_8);
            case 3 -> setSize(SandwichSize.LARGE_12);
            default -> {
                System.out.println("Invalid option. Defaulting to 8-inch.");
                setSize(SandwichSize.MEDIUM_8);
            }
        }
        System.out.println("Choose your bread please:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        System.out.println("You chose: ");
        String breadChoice = scanner.nextLine();

        switch (breadChoice) {
            case "1" -> setBreadType("White");
            case "2" -> setBreadType("Wheat");
            case "3" -> setBreadType("Rye");
            case "4" -> setBreadType("Wrap");
            default -> {
                System.out.println("Invalid bread choice. Defaulting to White.");
                setBreadType("White");
            }
        }

        System.out.println("Do you want toasted? (yes/no): ");
        String toastAnswer = scanner.nextLine();
        setToasted(toastAnswer.equalsIgnoreCase("yes"));

        System.out.println("Add meats (type 'done' to finish): ");
        while (true) {
            System.out.println("Add meat: ");
            String meat = scanner.nextLine();
            if (meat.equalsIgnoreCase("done")) break;
            addMeat(meat);

            System.out.println("Add cheeses (type 'done' to finish): ");
            while (true) {
                System.out.println("Add cheese: ");
                String cheese = scanner.nextLine();
                if (cheese.equalsIgnoreCase("done")) break;
                addCheese(cheese);

                System.out.println("Add regular toppings (type 'done' to finish): ");
                while (true) {
                    System.out.println("Add topping: ");
                    String topping = scanner.nextLine();
                    if (topping.equalsIgnoreCase("done")) break;
                    addTopping(topping);
                }
                System.out.println("Add sauces (type 'done' to finish): ");
                while (true) {
                    System.out.println("Add sauce: ");
                    String sauce = scanner.nextLine();
                    addSauce(sauce);
                }
            }
        }
    }

}
