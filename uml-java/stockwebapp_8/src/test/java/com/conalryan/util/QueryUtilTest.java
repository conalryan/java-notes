package com.conalryan.util;

import com.conalryan.model.Interval;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QueryUtilTest {

    private String symbol;
    private DateTime from;
    private DateTime until;
    private Interval interval;
    private String queryString;

    @Before
    public void setUp() throws Exception {
        symbol = "AAPL";
        from = new DateTime(2015,2,1,0,0,0,0);
        until = new DateTime(2015,2,28,0,0,0,0);
        interval = Interval.WEEKLY;

        queryString = "SELECT symbol, price, time FROM quotes WHERE symbol = 'AAPL' AND time >= '2015/02/01' AND time <= '2015/02/28' AND DAYOFWEEK(time) = 6 ORDER BY time";

    }

    @Test
    public void testCreateQuery() throws Exception {

        assertEquals("Query is correct", queryString,QueryUtil.createQuery(symbol, from, until, interval));
    }
}