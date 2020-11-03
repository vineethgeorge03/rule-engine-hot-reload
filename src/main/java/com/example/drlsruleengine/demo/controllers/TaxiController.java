package com.example.drlsruleengine.demo.controllers;

import com.example.drlsruleengine.demo.ruleModels.Fare;
import com.example.drlsruleengine.demo.services.TaxiFareCalculatorService;
import com.example.drlsruleengine.demo.services.TaxiFareCalculatorServiceImpl;
import com.example.drlsruleengine.demo.ruleModels.TaxiRide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxiController {

    @Autowired
    TaxiFareCalculatorService taxiFareCalculatorService;

    @GetMapping("/run/rules/taxi")
    public ResponseEntity<Double> fireRules() {
        TaxiRide taxiRide =  new TaxiRide();
        taxiRide.setNightSurcharge(false);
        taxiRide.setDistanceInMile(9L);
        Fare rideFare = new Fare();
        Double totalCharge = taxiFareCalculatorService.calculateFare(taxiRide, rideFare);
        return new ResponseEntity<>(totalCharge, HttpStatus.OK);
    }
}
