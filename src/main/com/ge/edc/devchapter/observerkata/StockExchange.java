package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subject;
import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class StockExchange implements Subject {

    List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void addSubscriber(Subscriber subscriber) {
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
    }

    @Override
    public void notifySubscribers() {

    }
}
