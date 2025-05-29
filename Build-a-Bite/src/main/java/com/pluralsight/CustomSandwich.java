package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomSandwich extends Sandwich {
    private List<Topping> meats = new ArrayList<>();
    private List<Topping> cheeses = new ArrayList<>();
    private List<Topping> regulars = new ArrayList<>();
    private List<Topping> sauces = new ArrayList<>();

    public CustomSandwich(Scanner scanner) {
        System.out.println("Select bread:");
        this.bread = MenuHelper.chooseFromList(scanner, MenuHelper.getBreadOptions());

        System.out.println("Select size (4/8/12):");
        this.size = SandwichSize.fromInput(scanner.nextLine());

        System.out.println("Select meats:");
        this.meats = MenuHelper.multiSelect(scanner, MenuHelper.getMeatOptions(), ToppingType.MEAT);

        System.out.println("Select cheeses:");
        this.cheeses = MenuHelper.multiSelect(scanner, MenuHelper.getCheeseOptions(), ToppingType.CHEESE);

        System.out.println("Select toppings:");
        this.regulars = MenuHelper.multiSelect(scanner, MenuHelper.getRegularToppings(), ToppingType.REGULAR);

        System.out.println("Select sauces:");
        this.sauces = MenuHelper.multiSelect(scanner, MenuHelper.getSauces(), ToppingType.SAUCE);

        System.out.println("Toasted? (yes/no)");
        this.toasted = scanner.nextLine().equalsIgnoreCase("yes");
    }

    public double getPrice() {
        double price = size.getBasePrice();

        for (Topping meat : meats) price += meat.getPrice(size);
        for (Topping cheese : cheeses) price += cheese.getPrice(size);

        return price;
    }

    public String getDetails() {
        return size + " " + bread + " " + (toasted ? "Toasted" : "Not Toasted");
    }
}

