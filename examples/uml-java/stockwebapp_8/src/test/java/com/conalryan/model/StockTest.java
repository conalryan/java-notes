package com.conalryan.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class StockTest {

    private int id;
    private String companyName;
    private String tickerSymbol;
    private String exchange;
    private Stock stock;

    @Before
    public void setUp() throws Exception {
        companyName = "Apple";
        tickerSymbol = "AAPL";
        exchange = "Nasdaq";
        stock = new Stock(companyName, tickerSymbol, exchange);
    }

    @Test
    public void testStock() throws Exception {assertNotNull("Stock created", stock);}

    @Test
    public void testGetId() throws Exception { assertEquals("Id get correct", id, stock.getId()); }

    @Test
    public void testSetId() throws Exception {
        stock.setId(1);
        assertEquals("Id set correct", 1, stock.getId());
    }
    @Test
    public void testGetCompanyName() throws Exception {assertEquals("Company get correct", companyName, stock.getCompanyName()); }

    @Test
    public void testSetCompanyName() throws Exception {
        stock.setCompanyName("Intel");
        assertEquals("Company name set correct", "Intel", stock.getCompanyName());
    }

    @Test
    public void testGetTickerSymbol() throws Exception { assertEquals("TickerSymbol get correct", "AAPL", stock.getTickerSymbol()); }

    @Test
    public void testSetTickerSymbol() throws Exception {
        stock.setTickerSymbol("INTC");
        assertEquals("TickerSymbol set correct", "INTC", stock.getTickerSymbol());
    }

    @Test
    public void testGetExchange() throws Exception { assertEquals("getExchange is corect", "Nasdaq", stock.getExchange()); }

    @Test
    public void testSetExchange() throws Exception {
        stock.setExchange("NYSE");
        assertEquals("exchangeSet is correct", "NYSE", stock.getExchange() );
    }

    @Test
    public void testEquals() throws Exception {
        Stock stock2 = new Stock("Apple", "AAPL", "Nasdaq");
        assertEquals("equals is correct", stock2, stock);
    }

    @Test
    public void testHashCode() throws Exception {
        Stock stock2 = new Stock("Apple", "AAPL", "Nasdaq");
        assertEquals("HashCode is correct", stock2.hashCode(), stock.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertNotNull("String is correct", stock.toString());
    }
}