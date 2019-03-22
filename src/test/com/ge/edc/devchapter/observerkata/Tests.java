package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedAnnotationTypes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

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
        stockExchange.addSubscriber((a, b) -> null);

        assertEquals(1, stockExchange.subscribers.size());
    }

    @Test
    public void StockExchangeShouldRemoveExistingSubscribers() {
        StockExchange stockExchange = new StockExchange();
        stockExchange.addSubscriber((a, b) -> null);
        stockExchange.removeSubscriber(stockExchange.subscribers.get(0));

        assertEquals(0, stockExchange.subscribers.size());
    }


    @Test
    public void StockExchangeShouldNotRemoveSubscriberIfNotSubscribed() {
        StockExchange stockExchange = new StockExchange();
        Subscriber sub = (a, b) -> null;
        stockExchange.addSubscriber((a, b) -> null);
        stockExchange.addSubscriber(sub);
        stockExchange.removeSubscriber((a, b) -> null);
        stockExchange.removeSubscriber(sub);

        assertEquals(1, stockExchange.subscribers.size());
    }

    @Test
    public void StockExchangeShouldNotifyAllSubscribersWhenExchangeRatesChanged() {
        StockExchange stockExchange = new StockExchange();
        stockExchange.addSubscriber(new SmartphoneApp());
        stockExchange.addSubscriber(new TvStrip());
        stockExchange.addSubscriber(new WebsiteChart());

        stockExchange.setExchangeRates(Collections.singletonMap("Test", 1.1));

    }

    @Test
    public void StockExchangeShouldNotifyAllSubscribersWhenIndicesChanged() {
        StockExchange stockExchange = new StockExchange();
        Subscriber smartphoneApp = new SmartphoneApp();
        Subscriber tvStrip = new TvStrip();
        Subscriber chart = new WebsiteChart();
        stockExchange.addSubscriber(smartphoneApp);
        stockExchange.addSubscriber(tvStrip);
        stockExchange.addSubscriber(chart);

        stockExchange.setIndices(Collections.singletonMap("IndicesTest", 1.1));

    }
}