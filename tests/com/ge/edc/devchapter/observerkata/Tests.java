package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

public class Tests {

    private HashMap<String, Double> indices = new HashMap<>();
    private HashMap<String, Double> rates = new HashMap<>();


    @Before
    public void prepareCollections(){
        indices.put("WIG20", 20d);
        indices.put("wig30", 13.43);
        indices.put("RESPECT", 43.);
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

        Mockito.verify(tvStrip).update(any(), any());
        Mockito.verify(smartphoneApp).update(any(), any());
        Mockito.verify(chart).update(any(), any());

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

        Mockito.verify(smartphoneApp).update(eq(rates), any());
        Mockito.verify(tvStrip).update(eq(rates), any());
        Mockito.verify(chart).update(eq(rates), any());

    }

    @Test
    public void StockExchangeShouldNotifyAllSubscribersWhenIndicesChanged() {

        StockExchange stockExchange = new StockExchange();
        Subscriber smartphoneApp = Mockito.spy(new SmartphoneApp());
        Subscriber tvStrip = Mockito.spy(new TvStrip());
        Subscriber chart = Mockito.spy(new WebsiteChart());
        stockExchange.addSubscriber(smartphoneApp);
        stockExchange.addSubscriber(tvStrip);
        stockExchange.addSubscriber(chart);

        stockExchange.setIndices(indices);

        Mockito.verify(smartphoneApp).update(any(), eq(indices));
        Mockito.verify(tvStrip).update(any(), eq(indices));
        Mockito.verify(chart).update(any(), eq(indices));

    }

    @Test
    public void StockExchangeShouldNotifyAllSubscribersWhenIndicesUpdated() {

        StockExchange stockExchange = new StockExchange();
        stockExchange.setIndices(indices);
        Subscriber smartphoneApp = Mockito.spy(new SmartphoneApp());
        Subscriber tvStrip = Mockito.spy(new TvStrip());
        Subscriber chart = Mockito.spy(new WebsiteChart());
        stockExchange.addSubscriber(smartphoneApp);
        stockExchange.addSubscriber(tvStrip);
        stockExchange.addSubscriber(chart);

        stockExchange.updateIndex("CoolnessIndex" , 123.333);
        HashMap<String, Double> newIndices = new HashMap<>(indices);
        newIndices.put("CoolnessIndex", 123.333);
        Mockito.verify(smartphoneApp).update(any(), eq(newIndices));
        Mockito.verify(tvStrip).update(any(), eq(newIndices));
        Mockito.verify(chart).update(any(), eq(newIndices));

    }

    @Test
    public void StockExchangeShouldNotifyAllSubscribersWhenRatesUpdated() {

        StockExchange stockExchange = new StockExchange();
        stockExchange.setExchangeRates(rates);
        Subscriber smartphoneApp = Mockito.spy(new SmartphoneApp());
        Subscriber tvStrip = Mockito.spy(new TvStrip());
        Subscriber chart = Mockito.spy(new WebsiteChart());
        stockExchange.addSubscriber(smartphoneApp);
        stockExchange.addSubscriber(tvStrip);
        stockExchange.addSubscriber(chart);

        stockExchange.updateExchangeRate("CoolCorp" , 123.333);
        HashMap<String, Double> newRates = new HashMap<>(rates);
        newRates.put("CoolCorp" , 123.333);

        Mockito.verify(smartphoneApp).update(eq(newRates), any());
        Mockito.verify(tvStrip).update(eq(newRates), any());
        Mockito.verify(chart).update(eq(newRates), any());

    }
}