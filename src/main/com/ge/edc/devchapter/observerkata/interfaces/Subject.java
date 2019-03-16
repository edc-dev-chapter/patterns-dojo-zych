package com.ge.edc.devchapter.observerkata.interfaces;

public interface Subject {

    public void addSubscriber(Subscriber subscriber);
    public void removeSubscriber(Subscriber subscriber);
    public void notifySubscribers();

}
