package com.pluralsight;

public class Cheese extends Topping {
    public Cheese(String name) {
        this.name = name;
    }

    @Override
    double calculateTotalPrice(String size) {
        return switch (size) {
            case "4\"" -> 0.75;
            case "8\"" -> 1.50;
            case "12\"" -> 2.25;
            default -> 0.0;
        };
    }
}
