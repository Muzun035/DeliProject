package com.pluralsight;

public class Meat extends Topping {
    public Meat(String name) {
        this.name = name;
    }

    @Override
    double calculateTotalPrice(String size) {
        return switch (size) {
            case "4\"" -> 1.00;
            case "8\"" -> 2.00;
            case "12\"" -> 3.00;
            default -> 0.0;
        };
    }
}
