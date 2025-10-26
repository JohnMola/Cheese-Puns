package org.example;

import java.util.*;
public class CheeseCollection {
     private List<Cheese> cheeses;

    public CheeseCollection(List<Cheese> cheeses) {
        this.cheeses = new ArrayList<>(cheeses);
    }

    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);
    }

    public List<Cheese> getAllCheeses() {
        return Collections.unmodifiableList(cheeses);
    }

    public void printAllCheeses() {
        System.out.println("Loaded Cheeses:");
        for (Cheese c : cheeses) {
            System.out.println(c);
        }
    }

    public List<Cheese> filterByProvince(String provCode) {
        List<Cheese> result = new ArrayList<>();
        for (Cheese c : cheeses) {
            if (c.getManufacturerProvCode().equalsIgnoreCase(provCode)) {
                result.add(c);
            }
        }
        return result;
    }
}
