package com.order;
import com.food.Chips;
import com.food.Drink;
import com.food.Sandwich;
import com.order.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class OrderFileManager {
    public static void saveReceipt(Order order) {
        String fileName = String.format("receipts/%tF-%<tH%<tM%<tS.txt", order.getOrderTime());
        File file = new File(fileName);
        file.getParentFile().mkdirs(); // Ensure the directory exists

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Receipt for customer: " + order.getCustomerName() + "\n");
            writer.write("Order time: " + order.getOrderTime() + "\n\n");

            writer.write("Sandwiches:\n");
            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write("- " + sandwich.getDescription() + " ($" + String.format("%.2f", sandwich.calculatePrice()) + ")\n");
            }

            writer.write("\nDrinks:\n");
            for (Drink drink : order.getDrinks()) {
                writer.write("- " + drink.getDescription() + " ($" + String.format("%.2f", drink.calculatePrice()) + ")\n");
            }

            writer.write("\nChips:\n");
            for (Chips chips : order.getChipsList()) {
                writer.write("- " + chips.getDescription() + " ($" + String.format("%.2f", chips.calculatePrice()) + ")\n");
            }

            writer.write("\nTotal Price: $" + String.format("%.2f", order.calculateTotalPrice()) + "\n");
        } catch (IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }
}