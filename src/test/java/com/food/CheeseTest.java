package com.food;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheeseTest {

    @Test
    public void testCheesePriceCalculation() {
        // Arrange: Setting up the cheese object
        String cheeseType = "Cheddar";
        Cheese cheese = new Cheese(cheeseType);
        String sandwichSize = "8\"";

        // Act: Calculate the price of the cheese
        double calculatedPrice = cheese.calculateTotalPrice(sandwichSize);

        // Assert: Verify that the calculated price is as expected
        double expectedPrice = 1.00; // Assuming that cheese for an 8" sandwich costs $1.00
        assertEquals(expectedPrice, calculatedPrice, 0.01, "Cheese price calculation is incorrect");
    }
}

