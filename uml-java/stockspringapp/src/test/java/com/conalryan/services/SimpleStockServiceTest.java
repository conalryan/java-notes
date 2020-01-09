package com.conalryan.services;

import com.conalryan.model.StockQuote;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SimpleStockServiceTest extends TestCase {

    private StockService stockService;
    private StockQuote stockQuote;
    private BigDecimal price;
    private DateTime date;
    private String symbol;

    private List<StockQuote> stockQuotes;

    public void setUp() throws Exception {

        stockService = new SimpleStockService();
        price = new BigDecimal(100);
        date = new DateTime(2015,2,28,0,0,0,0);
        symbol = "aapl";
        stockQuote = new StockQuote(price, date, symbol);
        stockQuotes = new ArrayList<>();
        stockQuotes.add(stockQuote);
    }

    @Test
    public void testGetQuote() throws Exception {
        assertEquals("Quote is correct", symbol, stockService.getQuote("aapl").getSymbol() );
    }

    public void testGetQuote1() throws Exception {

        assertTrue("Quotes are correct", stockQuotes.containsAll(stockService.getQuote("aapl", date, date)));
    }
}