package com.ge.edc.devchapter.observerkata;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;

public class StockExchangeTest {

    @Test
    public void smokeTest() {
        StockExchange stockExchange = new StockExchange();
        assertNotNull(stockExchange);
    }

    @Test
    public void testOfTests() {
        String asd = String.format("%s: %.2f", "asd", 90.548674);
        System.out.println(asd);
    }
}