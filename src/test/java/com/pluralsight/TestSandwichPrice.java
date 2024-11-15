package com.pluralsight;

import com.food.Cheese;
import com.food.Meat;
import com.food.RegularTopping;
import com.food.Sandwich;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSandwichPrice {

    // Test to verify that the price calculation for a sandwich with various toppings is correct
    @Test
    public void testSandwichPriceCalculation() {
        Sandwich sandwich = new Sandwich("8\"", "wheat");
        sandwich.addTopping(new Meat("Bacon"));
        sandwich.addTopping(new Cheese("Cheddar"));
        sandwich.addTopping(new RegularTopping("Lettuce"));
        sandwich.setToasted(true);

        double expectedPrice = 7.00 + 2.00 + 1.50; // Base price + Meat + Cheese
        assertEquals(expectedPrice, sandwich.calculatePrice(), 0.01, "Sandwich price calculation failed.");
    }
}
