package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subject;
import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockExchange implements Subject {
    private Map<String, Double> exchangeRates;
    private Map<String, Double> indices;
    List<Subscriber> subscribers;

    public StockExchange() {
        exchangeRates = new HashMap<>();
        indices = new HashMap<>();
        subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
    }

    public void setExchangeRates(Map<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public void setIndices(Map<String, Double> indices) {
        this.indices = indices;
    }

    public void updateExchangeRate(String company, Double rate) {
        this.exchangeRates.put(company, rate);
    }

    public void updateIndex(String indexName, Double rate) {
        this.indices.put(indexName, rate);
    }
}
