package org.example;

import java.io.*;
import java.util.*;

public class CheeseCSVReader {

    public static List<Cheese> readCheeseData(String fileName) {
         List<Cheese> cheeses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                 if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                 String[] data = new String[13];
                for (int i = 0; i < 13; i++) {
                    if (i < values.length) {
                        data[i] = values[i].trim().replaceAll("^\"|\"$", "");
                    } else {
                        data[i] = "";
                    }
                }

                try {
                    int cheeseId = parseIntSafe(data[0]);
                    String manufacturerProvCode = data[1];
                    String manufacturingTypeEn = data[2];
                    double moisturePercent = parseDoubleSafe(data[3]);
                    String flavourEn = data[4];
                    String characteristicsEn = data[5];
                    boolean organic = data[6].equals("1");
                    String categoryTypeEn = data[7];
                    String milkTypeEn = data[8];
                    String milkTreatmentTypeEn = data[9];
                    String rindTypeEn = data[10];
                    String cheeseName = data[11];
                    String fatLevel = data[12];

                    Cheese cheese = new Cheese(
                            cheeseId,
                            manufacturerProvCode,
                            manufacturingTypeEn,
                            moisturePercent,
                            flavourEn,
                            characteristicsEn,
                            organic,
                            categoryTypeEn,
                            milkTypeEn,
                            milkTreatmentTypeEn,
                            rindTypeEn,
                            cheeseName,
                            fatLevel
                    );
                    cheeses.add(cheese);

                } catch (Exception e) {
                    System.err.println("Skipping malformed line: " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return cheeses;
    }

    private static int parseIntSafe(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static double parseDoubleSafe(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
