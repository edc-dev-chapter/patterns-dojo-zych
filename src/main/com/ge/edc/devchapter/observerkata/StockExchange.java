package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subject;
import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Map;

public class StockExchange implements Subject {
    private Map<String, Double> exchangeRates;
    private Map<String, Double> indices;
    List<Subscriber> subscribers = new ArrayList<>();

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

    public Map<String, Double> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(Map<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public Map<String, Double> getIndices() {
        return indices;
    }

    public void setIndices(Map<String, Double> indices) {
        this.indices = indices;
    }
}
