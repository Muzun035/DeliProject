package com.pluralsight;

public class RegularTopping extends Topping {
    public RegularTopping(String name) {
        this.name = name;
    }

    @Override
    double calculateTotalPrice(String size) {
        return 0.0;
    }
}
