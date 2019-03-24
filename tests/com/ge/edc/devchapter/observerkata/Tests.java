package com.ge.edc.devchapter.observerkata;

import com.ge.edc.devchapter.observerkata.interfaces.Subscriber;
import org.junit.jupiter.api.Test;

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
}