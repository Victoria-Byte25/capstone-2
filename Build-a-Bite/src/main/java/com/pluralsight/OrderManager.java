package com.pluralsight;

import java.util.Scanner;

public class OrderManager {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Welcome to Build-a-Bite");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                Order order = new Order();
                handleOrder(order);
            } else if (choice.equals("0")) {
                break;
            }
        }
    }

    private void handleOrder(Order order) {
        while (true) {
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    order.addSandwich(new CustomSandwich(scanner));
                    break;
                case "2":
                    order.addDrink(new Drink(scanner));
                    break;
                case "3":
                    order.addChip(new Chip(scanner));
                    break;
                case "4":
                    order.checkout();
                    return;
                case "0":
                    return;
            }
        }
    }
}
