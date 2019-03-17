package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedAnnotationTypes;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    public void classSmartphoneAppImplementsSubscriber(){
        SmartphoneApp smartphoneApp = new SmartphoneApp();

        assertTrue(smartphoneApp instanceof Subscriber);
    }

    @Test
    public void classTvStripImplementsSubscriber(){
        TvStrip tvStrip = new TvStrip();

        assertTrue(tvStrip instanceof Subscriber);
    }

    @Test
    public void classWebsiteChartImplementsSubscriber(){
        WebsiteChart websiteChart = new WebsiteChart();

        assertTrue(websiteChart instanceof Subscriber);
    }

    @Test
    public void classStockExchangeImplementsSubject(){
        WebsiteChart websiteChart = new WebsiteChart();

        assertTrue(websiteChart instanceof Subscriber);
    }

    @Test
    public void StockExchangeAcceptsNewSubscribers() {
        StockExchange stockExchange = new StockExchange();
        stockExchange.addSubscriber(()->{});

        assertEquals(1, stockExchange.subscribers.size());
    }

    @Test
    public void StockExchangeShouldRemoveExistingSubscribers() {
        StockExchange stockExchange = new StockExchange();
        stockExchange.addSubscriber(()->{});
        stockExchange.removeSubscriber(stockExchange.subscribers.get(0));

        assertEquals(0, stockExchange.subscribers.size());
    }


    @Test
    public void StockExchangeShouldNotRemoveSubscriberIfNotSubscribed() {
        StockExchange stockExchange = new StockExchange();
        Subscriber sub = ()->{};
        stockExchange.addSubscriber(()->{});
        stockExchange.addSubscriber(sub);
        stockExchange.removeSubscriber(()->{});
        stockExchange.removeSubscriber(sub);

        assertEquals(1, stockExchange.subscribers.size());
    }
}