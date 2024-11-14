package com.pluralsight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDrinkCreation {

    // Test to verify that a drink with a specific size and flavor is created correctly
    @Test
    public void testDrinkCreation() {
        Drink drink = new Drink("Medium", "Sprite");
        assertEquals("Medium drink (Sprite)", drink.getDescription(), "Drink creation failed.");
        assertEquals(2.50, drink.calculatePrice(), 0.01, "Drink price calculation failed.");
    }
}
