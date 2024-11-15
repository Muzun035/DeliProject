package com.pluralsight;

public abstract class Topping {
    protected String name;

    public String getName() {
        return name;
    }

    abstract double calculateTotalPrice(String size);
}
