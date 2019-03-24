package com.ge.edc.devchapter.observerkata.interfaces;

import java.util.Map;

public interface Subscriber {

    public void update(Map<String, Double> exchangeRates, Map<String, Double> indices);

}
