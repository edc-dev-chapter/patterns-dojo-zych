package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;

public class WebsiteChart implements Subscriber {

    @Override
    public String update(Map<String, Double> exchangeRates, Map<String, Double> indices) {
        throw new NotImplementedException();
    }
}
