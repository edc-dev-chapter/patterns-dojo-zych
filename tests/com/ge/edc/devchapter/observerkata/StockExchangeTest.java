package com.ge.edc.devchapter.observerkata;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;

public class StockExchangeTest {

    @Test
    public void smokeTest() {
        StockExchange stockExchange = new StockExchange();
        assertNotNull(stockExchange);
    }

}