package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Build-a-Bite!");
        System.out.println("------------------------------");

        Order order = new Order();
        OrderManager.startOrder(order);
    }
}

