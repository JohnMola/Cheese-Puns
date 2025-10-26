package org.example;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        String fileName = "cheese_data.csv";

        List<Cheese> cheeseList = CheeseCSVReader.readCheeseData(fileName);
        CheeseCollection collection = new CheeseCollection(cheeseList);

        String outputFile = "output.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
             CheeseStatistics stats = new CheeseStatistics(collection);

            System.out.println("\n=== Cheese Statistics ===");
            writer.println("\n=== Cheese Statistics ===");

            stats.countByMilkTreatment(System.out, writer);

            stats.countOrganicHighMoisture(System.out, writer);

            stats.mostCommonMilkType(System.out, writer);

            System.out.println("\nStatistics also written to " + outputFile);

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
