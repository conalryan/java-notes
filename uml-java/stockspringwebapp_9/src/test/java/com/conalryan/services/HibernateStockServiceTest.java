package com.conalryan.services;

import com.conalryan.model.Interval;
import com.conalryan.model.StockQuote;
import com.conalryan.util.DatabaseUtils;
import com.conalryan.util.XMLUtils;
import com.conalryan.xml.Stocks;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.*;

public class HibernateStockServiceTest {

    private HibernateStockService hibernateStockService;

    @Before
    public void setUp() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
        hibernateStockService = new HibernateStockService();
    }

    @Test
    public void testGetQuote() throws Exception {
        StockQuote stockQuote = hibernateStockService.getQuote("AAPL");
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
    }

    @Test
    public void testGetQuote1() throws Exception {
        assertNotNull("Verify we can get a stock quote with dates",
                hibernateStockService.getQuote("AAPL", new DateTime(1994, 12, 31, 0, 0, 0, 0),
                        new DateTime(2005, 2, 3, 0, 0, 0, 0)));
    }

    @Test
    public void testGetQuote2() throws Exception {
        assertNotNull("Verify we can get a stock quote with dates",
                hibernateStockService.getQuote("AAPL", new DateTime(1994,12,31,0,0,0,0),
                        new DateTime(2005,2,3,0,0,0,0), Interval.ALL));
        assertNotNull("Verify we can get a stock quote with dates",
                hibernateStockService.getQuote("AAPL", new DateTime(1994,12,31,0,0,0,0),
                        new DateTime(2005,2,3,0,0,0,0), Interval.MONTHLY));
        assertNotNull("Verify we can get a stock quote with dates",
                hibernateStockService.getQuote("AAPL", new DateTime(1994,12,31,0,0,0,0),
                        new DateTime(2005,2,3,0,0,0,0), Interval.WEEKLY));
        assertNotNull("Verify we can get a stock quote with dates",
                hibernateStockService.getQuote("AAPL", new DateTime(1994,12,31,0,0,0,0),
                        new DateTime(2005,2,3,0,0,0,0), Interval.DAILY));
        assertNotNull("Verify we can get a stock quote with dates",
                hibernateStockService.getQuote("AAPL", new DateTime(1994,12,31,0,0,0,0),
                        new DateTime(2005,2,3,0,0,0,0), Interval.CASH_SESSION));
    }

    @Test
    public void testAddStockQuote() throws Exception {
        StockQuote stockQuote = new StockQuote(new BigDecimal(100),
                new DateTime(2015, 3, 8, 0, 0, 0, 0), "AAPL");
        HibernateStockService.addStockQuote(stockQuote);
    }

    @Test
    public void testAddStockQuotes() throws Exception {
        StockQuote stockQuote = new StockQuote(new BigDecimal(111),
                new DateTime(2015, 1, 1, 1, 0, 0, 0), "AAPL");
        StockQuote stockQuote2 = new StockQuote(new BigDecimal(222),
                new DateTime(2015, 2, 2, 2, 0, 0, 0), "GOOG");
        Collection<StockQuote> stocks = new ArrayList<>();
        stocks.add(stockQuote);
        stocks.add(stockQuote2);
        HibernateStockService.addStockQuotes(stocks);
    }

    @Test
    public void testAddStocksToDatabase() throws Exception {
        Stocks stocks = XMLUtils.unmarshall(new File("src/main/resources/stock_info_test.xml"), Stocks.class);
        HibernateStockService.addStocksToDatabase(stocks);
    }
}