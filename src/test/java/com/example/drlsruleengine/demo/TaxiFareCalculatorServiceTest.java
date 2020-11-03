package com.example.drlsruleengine.demo;

import com.example.drlsruleengine.demo.config.DroolsConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DroolsConfig.class)
class TaxiFareCalculatorServiceTest {

    @Autowired
    TaxiFareCalculatorService taxiFareCalculatorService;

    @Test
    public void rulesTest() {
        TaxiRide taxiRide =  new TaxiRide();
        taxiRide.setNightSurcharge(false);
        taxiRide.setDistanceInMile(9L);
        Fare rideFare = new Fare();
        Double totalCharge = taxiFareCalculatorService.calculateFare(taxiRide, rideFare);
        assertNotNull(totalCharge);
        assertEquals(Double.valueOf(70), totalCharge);

    }

}