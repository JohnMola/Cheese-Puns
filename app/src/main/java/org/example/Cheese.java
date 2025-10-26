package org.example;

public class Cheese {
    private int cheeseId;
    private String manufacturerProvCode;
    private String manufacturingTypeEn;
    private double moisturePercent;
    private String flavourEn;
    private String characteristicsEn;
    private boolean organic;
    private String categoryTypeEn;
    private String milkTypeEn;
    private String milkTreatmentTypeEn;
    private String rindTypeEn;
    private String cheeseName;
    private String fatLevel;

    public Cheese(int cheeseId, String manufacturerProvCode, String manufacturingTypeEn,
                  double moisturePercent, String flavourEn, String characteristicsEn,
                  boolean organic, String categoryTypeEn, String milkTypeEn,
                  String milkTreatmentTypeEn, String rindTypeEn, String cheeseName, String fatLevel) {
        this.cheeseId = cheeseId;
        this.manufacturerProvCode = manufacturerProvCode;
        this.manufacturingTypeEn = manufacturingTypeEn;
        this.moisturePercent = moisturePercent;
        this.flavourEn = flavourEn;
        this.characteristicsEn = characteristicsEn;
        this.organic = organic;
        this.categoryTypeEn = categoryTypeEn;
        this.milkTypeEn = milkTypeEn;
        this.milkTreatmentTypeEn = milkTreatmentTypeEn;
        this.rindTypeEn = rindTypeEn;
        this.cheeseName = cheeseName;
        this.fatLevel = fatLevel;
    }

    public boolean isOrganic() {
        return organic;
    }

    public String getMilkTypeEn() {
        return milkTypeEn;
    }

    public String getMilkTreatmentTypeEn() {
        return milkTreatmentTypeEn;
    }

    public double getMoisturePercent() {
        return moisturePercent;
    }

    public String getManufacturerProvCode() {
        return manufacturerProvCode;
    }

    public String getCheeseName() {
        return cheeseName;
    }

    @Override
    public String toString() {
        return String.format("%d | %s | %s | %.1f%% | %s | %s | Organic: %b | %s | %s | %s | %s | %s | %s",
                cheeseId, manufacturerProvCode, manufacturingTypeEn, moisturePercent,
                flavourEn, characteristicsEn, organic, categoryTypeEn, milkTypeEn,
                milkTreatmentTypeEn, rindTypeEn, cheeseName, fatLevel);
    }
}
