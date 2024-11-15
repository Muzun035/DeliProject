package com.pluralsight;

public class Chips implements IPriceable {
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public double calculatePrice() {
        return 1.50;
    }

    public String getDescription() {
        return type + " chips";
    }
}
