package com.conalryan.model;

import org.joda.time.format.DateTimeFormat;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import org.joda.time.format.DateTimeFormatter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for StockQuery Class
 */
public class StockQueryTest {

    private String symbol;
    private String from;
    private String until;
    private String interval;
    private StockQuery stockQuery;
    private DateTimeFormatter dateTimeFormatter;

    @Before
    public void setUp() throws ParseException {
        symbol = "APPL";
        from = "2010/11/11";
        until = "2015/02/01";
        interval = "WEEKLY";
        stockQuery = new StockQuery(symbol, from, until, interval);
        dateTimeFormatter = DateTimeFormat.forPattern("yyyy/MM/dd");
    }

    @Test
    public void testBasicConstruction() throws Exception{ assertNotNull(stockQuery); }

    @Test
    public void testGetSymbol() { assertEquals("Symbol is correct", symbol, stockQuery.getSymbol()); }

    @Test
    public void testGetFrom() {
        assertEquals("Date from is correct", from, dateTimeFormatter.print(stockQuery.getFrom()));
    }

    @Test
    public void testGetUntil() {
        assertEquals("Date until is correct", until, dateTimeFormatter.print(stockQuery.getUntil()));
    }

    @Test
    public void testGetInterval() {
        assertEquals("Interval is correct", Interval.WEEKLY, stockQuery.getInterval());
    }

}
