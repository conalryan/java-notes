package com.conalryan.services;

import com.conalryan.model.Interval;
import com.conalryan.model.StockQuote;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class YahooStockServiceTest {

    private YahooStockService yahooStockService;
    private String symbol;
    private DateTime from;
    private DateTime until;
    private Interval interval;

    private BigDecimal price;
    private DateTime dateTime;
    private StockQuote stockQuote;

    @Before
    public void setUp() throws Exception {
        yahooStockService = new YahooStockService();
        symbol = "AAPL";
        from = new DateTime(2015, 1, 13, 0, 0, 0, 0);
        until = new DateTime();
        interval = Interval.MONTHLY;
    }

    @Test
    public void testCreation() throws Exception {
        assertNotNull("Creation successful", yahooStockService);
    }

    @Test
    public void testGetQuote() throws Exception {
        assertEquals("Quote correct", yahooStockService.getQuote(symbol).getSymbol(), symbol);
    }

    @Test
    public void testGetQuote1() throws Exception {
        assertNotNull("Quote correct", yahooStockService.getQuote(symbol, from, until));
    }

    @Test
    public void testGetQuote2() throws Exception {
        assertNotNull("Quote correct", yahooStockService.getQuote(symbol, from, until, interval));
    }
}