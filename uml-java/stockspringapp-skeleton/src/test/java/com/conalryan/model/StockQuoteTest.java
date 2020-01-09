package com.conalryan.model;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for StockQuote class
 */
public class StockQuoteTest {

    private BigDecimal price;
    private DateTime date;
    private String symbol;
    private StockQuote stockQuote;

    @Before
    public void setUp() {
        price = new BigDecimal(100);
        date = new DateTime(2015, 2, 23, 0, 0, 0, 0);
        symbol = "AAPL";
        stockQuote = new StockQuote(price, date, symbol);
    }

    @Test
    public void testCreateObject() {
        assertNotNull(stockQuote);
    }

    @Test
    public void testGetPrice() {
        assertEquals("Share price is correct", price, stockQuote.getPrice());
    }

    @Test
    public void testGetDate() {
        assertEquals("Share date is correct", date, stockQuote.getDate());
    }

    @Test
    public void testGetSymbol() {
        assertEquals("Symbol  is correct", symbol, stockQuote.getSymbol());
    }

    @Test
    public void testToString() {
        assertNotNull(stockQuote.toString());
    }

    @Test
    public void testEquals() {
        BigDecimal price2 = new BigDecimal(100);
        DateTime date2 = new DateTime(2015,2,23,0,0,0,0);
        String symbol2 = "AAPL";
        StockQuote stockQuote2 = new StockQuote(price2, date2, symbol2);
        assertEquals("Stocks_copy are equal", stockQuote, stockQuote2);
    }

    @Test
    public void testHashCode() {
        BigDecimal price2 = new BigDecimal(100);
        DateTime date2 = new DateTime(2015,2,23,0,0,0,0);
        String symbol2 = "AAPL";
        StockQuote stockQuote2 = new StockQuote(price2, date2, symbol2);
        assertEquals("Stock hashes are equal", stockQuote2.hashCode(), stockQuote.hashCode());
    }
}

