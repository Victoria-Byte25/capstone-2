package com.pluralsight;

public abstract class Sandwich {
    protected String bread;
    protected SandwichSize size;
    protected boolean toasted;

    public abstract double getPrice();
    public abstract String getDetails();
}