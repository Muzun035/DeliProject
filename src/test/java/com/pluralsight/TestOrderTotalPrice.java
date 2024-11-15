package com.pluralsight;

import com.food.*;
import com.order.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestOrderTotalPrice {

    // Test to verify that an order's total price calculation with multiple items is correct
    @Test
    public void testOrderTotalPriceCalculation() {
        // Arrange
        Order order = new Order("John Doe");
        Sandwich sandwich = new Sandwich("12\"", "rye");
        sandwich.addTopping(new Meat("Chicken"));
        sandwich.addTopping(new Cheese("Swiss"));
        sandwich.addTopping(new Sauce("Mayo"));
        order.addSandwich(sandwich);

        Drink drink = new Drink("Large", "Coke");
        order.addDrink(drink);

        Chips chips = new Chips("Potato");
        order.addChips(chips);

        double expectedTotal = 8.50 + 3.00 + 1.50 + 3.00; // Sandwich + Drink + Chips

        // Act
        double totalPrice =  order.calculateTotalPrice();

        // Assert
        assertEquals(expectedTotal, totalPrice, 0.01, "Order total price calculation failed.");
    }
}
