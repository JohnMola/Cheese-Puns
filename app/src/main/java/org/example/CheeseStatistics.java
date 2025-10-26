package org.example;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

public class CheeseStatistics {
    private CheeseCollection collection;

    public CheeseStatistics(CheeseCollection collection) {
        this.collection = collection;
    }

    public void countByMilkTreatment(PrintStream console, PrintWriter file) {
        int pasteurizedCount = 0;
        int rawCount = 0;

        for (Cheese c : collection.getAllCheeses()) {
            String treatment = c.getMilkTreatmentTypeEn().toLowerCase();
            if (treatment.contains("pasteurized")) {
                pasteurizedCount++;
            } else if (treatment.contains("raw")) {
                rawCount++;
            }
        }

        String output1 = "Milk Treatment Summary:";
        String output2 = " - Pasteurized milk cheeses: " + pasteurizedCount;
        String output3 = " - Raw milk cheeses: " + rawCount;

        console.println(output1);
        console.println(output2);
        console.println(output3);

        file.println(output1);
        file.println(output2);
        file.println(output3);
    }

    public void countOrganicHighMoisture(PrintStream console, PrintWriter file) {
        int count = 0;
        for (Cheese c : collection.getAllCheeses()) {
            if (c.isOrganic() && c.getMoisturePercent() > 41.0) {
                count++;
            }
        }

        String output = "Organic cheeses with >41.0% moisture: " + count;

        console.println(output);
        file.println(output);
    }

    public void mostCommonMilkType(PrintStream console, PrintWriter file) {
        Map<String, Integer> milkTypeCounts = new HashMap<>();

        for (Cheese c : collection.getAllCheeses()) {
             String milkType = c.getMilkTypeEn().trim().toLowerCase();
            milkTypeCounts.put(milkType, milkTypeCounts.getOrDefault(milkType, 0) + 1);
        }

        String mostCommon = null;
        int maxCount = 0;

         for (Map.Entry<String, Integer> entry : milkTypeCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        String output = "Most common milk type in Canada: " +
                (mostCommon != null ? mostCommon + " (" + maxCount + " cheeses)" : "No data");

        console.println(output);
        file.println(output);
    }
}
