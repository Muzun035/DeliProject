package com.pluralsight;


import java.util.ArrayList;
import java.util.List;

class Sandwich implements IPriceable {
    private String size;
    private String breadType;
    private List<Topping> toppings = new ArrayList<>();
    private boolean isToasted;

    public Sandwich(String size, String breadType) {
        this.size = size;
        this.breadType = breadType;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void setToasted(boolean toasted) {
        this.isToasted = toasted;
    }

    @Override
    public double calculatePrice() {
        double price;
        switch (size) {
            case "4\"":
                price = 5.50;
                break;
            case "8\"":
                price = 7.00;
                break;
            case "12\"":
                price = 8.50;
                break;
            default:
                price = 0.0;
        }
        for (Topping topping : toppings) {
            price += topping.calculateTotalPrice(size);
        }
        return price;
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append(size).append(" sandwich on ").append(breadType).append(" bread");
        if (isToasted) {
            description.append(" (toasted)");
        }
        description.append(" with:");
        for (Topping topping : toppings) {
            description.append("\n  - ").append(topping.getName());
        }
        return description.toString();
    }
}
