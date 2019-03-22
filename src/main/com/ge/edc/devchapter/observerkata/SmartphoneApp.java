package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;

import java.util.Map;

public class SmartphoneApp implements Subscriber {

    @Override
    public String update(Map<String, Double> exchangeRates, Map<String, Double> indices) {
        return "";
    }
}
