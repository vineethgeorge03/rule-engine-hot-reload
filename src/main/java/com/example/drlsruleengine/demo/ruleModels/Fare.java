package com.example.drlsruleengine.demo.ruleModels;

public class Fare {
    private Double nightSurcharge;
    private Double rideFare;

    public Double getNightSurcharge() {
        return nightSurcharge;
    }

    public void setNightSurcharge(Double nightSurcharge) {
        this.nightSurcharge = nightSurcharge;
    }

    public Double getRideFare() {
        return rideFare;
    }

    public void setRideFare(Double rideFare) {
        this.rideFare = rideFare;
    }
}
