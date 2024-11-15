package com.food;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularToppingTest {
    @Test
    public void testRegularToppingPriceCalculation() {
        // Arrange: Set up the regular topping object
        String toppingType = "Tomato";
        RegularTopping regularTopping = new RegularTopping(toppingType);
        String sandwichSize = "8\"";

        // Act: Calculate the price of the regular topping
        double calculatedPrice = regularTopping.calculateTotalPrice(sandwichSize);

        // Assert: Verify that the calculated price is as expected
        double expectedPrice = 0.0; // Assuming that regular toppings are free
        assertEquals(expectedPrice, calculatedPrice, 0.01, "Regular topping price calculation is incorrect");
    }
}