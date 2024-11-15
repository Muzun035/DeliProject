package com.food;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chipsList = new ArrayList<>();
    private String customerName;
    private Date orderTime;

    public Order(String customerName) {
        this.customerName = customerName;
        this.orderTime = new Date();
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chips) {
        chipsList.add(chips);
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Sandwich sandwich : sandwiches) {
            totalPrice += sandwich.calculatePrice();
        }
        for (Drink drink : drinks) {
            totalPrice += drink.calculatePrice();
        }
        for (Chips chips : chipsList) {
            totalPrice += chips.calculatePrice();
        }
        return totalPrice;
    }

    public void generateReceipt() {
        OrderFileManager.saveReceipt(this);
    }

    public String getCustomerName() {
        return customerName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChipsList() {
        return chipsList;
    }
}