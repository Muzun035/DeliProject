package com.pluralsight;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order currentOrder;

    public void displayMainMenu() {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to DELI-cious! Please select an option:");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            int selection = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            running = processUserSelection(selection);
        }
    }

    public boolean processUserSelection(int selection) {
        switch (selection) {
            case 1 -> {
                startNewOrder();
                return true;
            }
            case 0 -> {
                System.out.println("Thank you for visiting DELI-cious!");
                return false;
            }
            default -> {
                System.out.println("Invalid selection. Please try again.");
                return true;
            }
        }
    }

    private void startNewOrder() {
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();
        currentOrder = new Order(customerName);
        boolean ordering = true;
        while (ordering) {
            System.out.println("Order Menu:");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            int selection = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            ordering = processOrderSelection(selection);
        }
    }

    private boolean processOrderSelection(int selection) {
        switch (selection) {
            case 1 -> addSandwich();
            case 2 -> addDrink();
            case 3 -> addChips();
            case 4 -> {
                checkoutOrder();
                return false;
            }
            case 0 -> {
                System.out.println("Order canceled.");
                return false;
            }
            default -> System.out.println("Invalid selection. Please try again.");
        }
        return true;
    }

    private void addSandwich() {
        System.out.println("Select bread type (white, wheat, rye, wrap):");
        String breadType = scanner.nextLine();
        System.out.println("Select sandwich size (4\", 8\", 12\"):");
        String size = scanner.nextLine();
        Sandwich sandwich = new Sandwich(size, breadType);

        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("Select topping type:");
            System.out.println("1) Meat");
            System.out.println("2) Cheese");
            System.out.println("3) Regular Topping");
            System.out.println("4) Sauce");
            System.out.println("0) Done adding toppings");
            int toppingSelection = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (toppingSelection) {
                case 1 -> {
                    System.out.println("Enter meat type: -steak\n" +
                            "- ham\n" +
                            "- salami\n" +
                            "- roast beef\n" +
                            "- chicken\n" +
                            "- bacon");
                    String meatType = scanner.nextLine();
                    sandwich.addTopping(new Meat(meatType));
                }
                case 2 -> {
                    System.out.println("Enter cheese type: - american\n" +
                            "- provolone\n" +
                            "- cheddar\n" +
                            "- swiss");
                    String cheeseType = scanner.nextLine();
                    sandwich.addTopping(new Cheese(cheeseType));
                }
                case 3 -> {
                    System.out.println("Enter regular topping type: - lettuce\n" +
                            "- peppers\n" +
                            "- onions\n" +
                            "- tomatoes\n" +
                            "- jalapenos\n" +
                            "- cucumbers\n" +
                            "- pickles\n" +
                            "- guacamole\n" +
                            "- mushrooms");
                    String regularTopping = scanner.nextLine();
                    sandwich.addTopping(new RegularTopping(regularTopping));
                }
                case 4 -> {
                    System.out.println("Enter sauce type: - mayo\n" +
                            "- mustard\n" +
                            "- ketchup\n" +
                            "- ranch\n" +
                            "- thousand islands\n" +
                            "- vinaigrette");
                    String sauceType = scanner.nextLine();
                    sandwich.addTopping(new Sauce(sauceType));
                }
                case 0 -> addingToppings = false;
                default -> System.out.println("Invalid selection. Please try again.");
            }
        }

        System.out.println("Would you like the sandwich toasted? (yes/no):");
        String toasted = scanner.nextLine();
        sandwich.setToasted(toasted.equalsIgnoreCase("yes"));

        currentOrder.addSandwich(sandwich);
    }

    private void addDrink() {
        System.out.println("Select drink size (Small, Medium, Large):");
        String size = scanner.nextLine();
        System.out.println("Enter flavor:");
        String flavor = scanner.nextLine();
        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);
    }

    private void addChips() {
        System.out.println("Enter chip type:");
        String type = scanner.nextLine();
        Chips chips = new Chips(type);
        currentOrder.addChips(chips);
    }

    private void checkoutOrder() {
        System.out.println("Order details:");
        System.out.printf("Total price: $%.2f%n", currentOrder.calculateTotalPrice());
        System.out.println("Confirm order? (yes/no):");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            currentOrder.generateReceipt();
            System.out.println("Order confirmed and receipt generated.");
        } else {
            System.out.println("Order canceled.");
        }
    }
}