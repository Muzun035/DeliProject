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
        double price = switch (size) {
            case "4\"" -> 5.50;
            case "8\"" -> 7.00;
            case "12\"" -> 8.50;
            default -> 0.0;
        };
        for (Topping topping : toppings) {
            price += topping.calculateTotalPrice(size);
        }
        return price;
    }
}
