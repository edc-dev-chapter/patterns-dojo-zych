package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subject;
import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class StockExchange implements Subject {

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
}
