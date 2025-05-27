package com.pluralsight;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }
    public static void runApp() {
        boolean running = true;

        while (running) {
            System.out.println("=====================");
            System.out.println("Welcome to Build-a-Bite!");
            System.out.println("1) Start your order");
            System.out.println("2) Exit");
            System.out.println("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Order currentOrder = new Order();
                    OrderManager.startOrder(currentOrder);
                    break;
                case "0":
                    System.out.println("Thanks for Biting. See ya!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1 or 0.");
            }
        }

    }
}
