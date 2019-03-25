package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.annotation.processing.SupportedAnnotationTypes;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;

class Tests {

    HashMap<String, Double> indices = new HashMap<>();
    HashMap<String, Double> rates = new HashMap<>();


    @BeforeEach
    public void prepareCollections(){

        rates.put("ZychoCorp", 1000.234);
        rates.put("SolInvictus", 43.4432);
        rates.put("EDC", 34.4342);
    }

    @Test
    public void classSmartphoneAppImplementsSubscriber() {
        SmartphoneApp smartphoneApp = new SmartphoneApp();

        assertTrue(smartphoneApp instanceof Subscriber);
    }

    @Test
    public void classTvStripImplementsSubscriber() {
        TvStrip tvStrip = new TvStrip();

        assertTrue(tvStrip instanceof Subscriber);
    }

    @Test
    public void classWebsiteChartImplementsSubscriber() {
        WebsiteChart websiteChart = new WebsiteChart();

        assertTrue(websiteChart instanceof Subscriber);
    }

    @Test
    public void classStockExchangeImplementsSubject() {
        WebsiteChart websiteChart = new WebsiteChart();

        assertTrue(websiteChart instanceof Subscriber);
    }

    @Test
    public void StockExchangeAcceptsNewSubscribers() {
        StockExchange stockExchange = new StockExchange();
        stockExchange.addSubscriber((a, b) -> {});

        assertEquals(1, stockExchange.subscribers.size());
    }

    @Test
    public void StockExchangeShouldRemoveExistingSubscribers() {
        StockExchange stockExchange = new StockExchange();
        stockExchange.addSubscriber((a, b) -> {});
        stockExchange.removeSubscriber(stockExchange.subscribers.get(0));

        assertEquals(0, stockExchange.subscribers.size());
    }


    @Test
    public void StockExchangeShouldNotRemoveSubscriberIfNotSubscribed() {
        StockExchange stockExchange = new StockExchange();
        Subscriber sub = (a, b) -> {};
        stockExchange.addSubscriber((a, b) -> {});
        stockExchange.addSubscriber(sub);
        stockExchange.removeSubscriber((a, b) -> {});
        stockExchange.removeSubscriber(sub);

        assertEquals(1, stockExchange.subscribers.size());
    }

    @Test
    public void StockExchangeShouldNotifyAllSubscribers() {
        StockExchange stockExchange = new StockExchange();
        Subscriber smartphoneApp = Mockito.spy(new SmartphoneApp());
        Subscriber tvStrip = Mockito.spy(new TvStrip());
        Subscriber chart = Mockito.spy(new WebsiteChart());
        stockExchange.addSubscriber(smartphoneApp);
        stockExchange.addSubscriber(tvStrip);
        stockExchange.addSubscriber(chart);

        stockExchange.notifySubscribers();

        Mockito.verify(smartphoneApp).update(eq(rates), eq(indices));
        Mockito.verify(tvStrip).update(eq(rates), eq(indices));
        Mockito.verify(chart).update(eq(rates), eq(indices));

    }

    @Test
    public void StockExchangeShouldNotifyAllSubscribersWhenExchangeRatesChanged() {
        StockExchange stockExchange = new StockExchange();
        Subscriber smartphoneApp = Mockito.spy(new SmartphoneApp());
        Subscriber tvStrip = Mockito.spy(new TvStrip());
        Subscriber chart = Mockito.spy(new WebsiteChart());
        stockExchange.addSubscriber(smartphoneApp);
        stockExchange.addSubscriber(tvStrip);
        stockExchange.addSubscriber(chart);

        stockExchange.setExchangeRates(rates);

        Mockito.verify(smartphoneApp).update(eq(rates), eq(indices));
        Mockito.verify(tvStrip).update(eq(rates), eq(indices));
        Mockito.verify(chart).update(eq(rates), eq(indices));

    }

    @Test
    public void StockExchangeShouldNotifyAllSubscribersWhenIndicesChanged() {
        indices.put("WIG20", 20d);
        indices.put("wig30", 13.43);
        indices.put("RESPECT", 43.);

        StockExchange stockExchange = new StockExchange();
        Subscriber smartphoneApp = Mockito.spy(new SmartphoneApp());
        Subscriber tvStrip = Mockito.spy(new TvStrip());
        Subscriber chart = Mockito.spy(new WebsiteChart());
        stockExchange.addSubscriber(smartphoneApp);
        stockExchange.addSubscriber(tvStrip);
        stockExchange.addSubscriber(chart);

        stockExchange.setIndices(indices);

        Mockito.verify(smartphoneApp).update(eq(rates), eq(indices));
        Mockito.verify(tvStrip).update(eq(rates), eq(indices));
        Mockito.verify(chart).update(eq(rates), eq(indices));

    }
}