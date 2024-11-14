package com.pluralsight;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order currentOrder;

    private static final String[] MEAT_OPTIONS = {"Bacon", "Ham", "Salami", "Roast Beef", "Chicken", "Steak"};
    private static final String[] CHEESE_OPTIONS = {"American", "Provolone", "Cheddar", "Swiss"};
    private static final String[] REGULAR_TOPPING_OPTIONS = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
    private static final String[] SAUCE_OPTIONS = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Island", "Vinaigrette"};

    public void displayMainMenu() {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to DELI-cious! Please select an option:");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            int selection = scanner.nextInt();
            scanner.nextLine();
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
            scanner.nextLine();
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
        System.out.println("Would you like to select a signature sandwich or build your own?");
        System.out.println("1) Signature Sandwich");
        System.out.println("2) Build Your Own");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            addSignatureSandwich();
        } else {
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
                scanner.nextLine(); 

                switch (toppingSelection) {
                    case 1 -> {
                        System.out.println("Select meat type:");
                        for (int i = 0; i < MEAT_OPTIONS.length; i++) {
                            System.out.println((i + 1) + ") " + MEAT_OPTIONS[i]);
                        }
                        int meatChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (meatChoice > 0 && meatChoice <= MEAT_OPTIONS.length) {
                            sandwich.addTopping(new Meat(MEAT_OPTIONS[meatChoice - 1]));
                        } else {
                            System.out.println("Invalid selection.");
                        }
                    }
                    case 2 -> {
                        System.out.println("Select cheese type:");
                        for (int i = 0; i < CHEESE_OPTIONS.length; i++) {
                            System.out.println((i + 1) + ") " + CHEESE_OPTIONS[i]);
                        }
                        int cheeseChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (cheeseChoice > 0 && cheeseChoice <= CHEESE_OPTIONS.length) {
                            sandwich.addTopping(new Cheese(CHEESE_OPTIONS[cheeseChoice - 1]));
                        } else {
                            System.out.println("Invalid selection.");
                        }
                    }
                    case 3 -> {
                        boolean addingRegularToppings = true;
                        while (addingRegularToppings) {
                            System.out.println("Select regular topping type:");
                            for (int i = 0; i < REGULAR_TOPPING_OPTIONS.length; i++) {
                                System.out.println((i + 1) + ") " + REGULAR_TOPPING_OPTIONS[i]);
                            }
                            int toppingChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (toppingChoice > 0 && toppingChoice <= REGULAR_TOPPING_OPTIONS.length) {
                                sandwich.addTopping(new RegularTopping(REGULAR_TOPPING_OPTIONS[toppingChoice - 1]));
                            } else {
                                System.out.println("Invalid selection.");
                            }
                            System.out.println("Would you like to add another regular topping? (yes/no):");
                            String addMore = scanner.nextLine();
                            if (!addMore.equalsIgnoreCase("yes")) {
                                addingRegularToppings = false;
                            }
                        }
                    }
                    case 4 -> {
                        boolean addingSauces = true;
                        while (addingSauces) {
                            System.out.println("Select sauce type:");
                            for (int i = 0; i < SAUCE_OPTIONS.length; i++) {
                                System.out.println((i + 1) + ") " + SAUCE_OPTIONS[i]);
                            }
                            int sauceChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (sauceChoice > 0 && sauceChoice <= SAUCE_OPTIONS.length) {
                                sandwich.addTopping(new Sauce(SAUCE_OPTIONS[sauceChoice - 1]));
                            } else {
                                System.out.println("Invalid selection.");
                            }
                            System.out.println("Would you like to add another sauce? (yes/no):");
                            String addMore = scanner.nextLine();
                            if (!addMore.equalsIgnoreCase("yes")) {
                                addingSauces = false;
                            }
                        }
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
    }

    private void addSignatureSandwich() {
        System.out.println("Select a signature sandwich:");
        System.out.println("1) BLT");
        System.out.println("2) Philly Cheese Steak");
        int selection = scanner.nextInt();
        scanner.nextLine();

        Sandwich sandwich;
        switch (selection) {
            case 1 -> {
                sandwich = new Sandwich("8\"", "white");
                sandwich.addTopping(new Meat("Bacon"));
                sandwich.addTopping(new Cheese("Cheddar"));
                sandwich.addTopping(new RegularTopping("Lettuce"));
                sandwich.addTopping(new RegularTopping("Tomato"));
                sandwich.addTopping(new Sauce("Ranch"));
                sandwich.setToasted(true);
            }
            case 2 -> {
                sandwich = new Sandwich("8\"", "white");
                sandwich.addTopping(new Meat("Steak"));
                sandwich.addTopping(new Cheese("American"));
                sandwich.addTopping(new RegularTopping("Peppers"));
                sandwich.addTopping(new Sauce("Mayo"));
                sandwich.setToasted(true);
            }
            default -> {
                System.out.println("Invalid selection. Please try again.");
                return;
            }
        }
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