package com.conalryan.services;

import com.conalryan.model.StockQuote;
import com.conalryan.util.DatabaseUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the DatabaseStockService
 */
public class DatabaseStockServiceTest {

    private DatabaseStockService databaseStockService;
    private String symbol;
    private StockQuote stockQuote;

    @Before
    public void setUp() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
        databaseStockService = new DatabaseStockService();
        symbol = "AAPL";

    }

    @Test
    public void testGetQuote1() throws Exception {
        stockQuote = databaseStockService.getQuote(symbol);
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
    }

    @Test
    public void testGetQuote2() throws Exception {

    }

    @Test
    public void testGetQuote3() throws Exception {

    }
}
