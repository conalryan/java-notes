package com.conalryan.util;

import com.conalryan.model.Interval;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntervalUtilTest {

    private yahoofinance.histquotes.Interval yahooInterval;
    private yahoofinance.histquotes.Interval yahooConverted;

    @Before
    public void setUp() {
        Interval interval = Interval.MONTHLY;
        yahooInterval = yahoofinance.histquotes.Interval.MONTHLY;
        yahooConverted = IntervalUtil.convertInterval(interval);
    }

    @Test
    public void testConvertInterval() throws Exception {
        assertEquals("Intervals are correct", yahooInterval, yahooConverted);
    }
}