package com.food;

public class Sauce extends Topping {
    public Sauce(String name) {
        this.name = name;
    }

    @Override
    double calculateTotalPrice(String size) {
        return 0.0;
    }
}
