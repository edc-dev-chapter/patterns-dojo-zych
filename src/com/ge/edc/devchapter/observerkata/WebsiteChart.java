package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;

public class WebsiteChart implements Subscriber {

    @Override
    public void update(Map<String, Double> exchangeRates, Map<String, Double> indices) {
        displayCharts(indices);
    }

    private void displayCharts(Map<String, Double> indices) {
        indices.forEach((i, v) -> {
            System.out.println(
                    String.format("Updating chart of index %s with value %.2f", i, v)
            );
        });
    }
}
