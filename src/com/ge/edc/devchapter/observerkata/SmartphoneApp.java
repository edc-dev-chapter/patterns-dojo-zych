package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;

public class SmartphoneApp implements Subscriber {

    @Override
    public void update(Map<String, Double> exchangeRates, Map<String, Double> indices) {
        buzzPhone();
    }

    private void buzzPhone() {
        System.out.println("Phone is buzzing because there is new data from Stock Exchange!");
    }
}
