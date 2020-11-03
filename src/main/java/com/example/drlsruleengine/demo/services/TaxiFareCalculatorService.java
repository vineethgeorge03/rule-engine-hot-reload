package com.example.drlsruleengine.demo.services;

import com.example.drlsruleengine.demo.ruleModels.Fare;
import com.example.drlsruleengine.demo.ruleModels.TaxiRide;

public interface TaxiFareCalculatorService {
    Double calculateFare(TaxiRide taxiRide, Fare rideFate);
}
