package com.conalryan.util;

import com.conalryan.model.Interval;

/**
 * Created by Conal on 3/14/2015.
 * Class is used to convert Interval enums
 */
public class IntervalUtil {

    /**
     * Convert Interval to Yahoo Finance Interval
     * @param interval
     * @return yahoofinance.histquotes.Interval
     */
    public static yahoofinance.histquotes.Interval convertInterval(Interval interval) {

        yahoofinance.histquotes.Interval yahooInterval = null;

        switch(interval) {

            case MONTHLY:
                yahooInterval = yahoofinance.histquotes.Interval.MONTHLY;
                break;
            case WEEKLY:
                yahooInterval = yahoofinance.histquotes.Interval.WEEKLY;
                break;
            case DAILY:
                yahooInterval = yahoofinance.histquotes.Interval.DAILY;
                break;
        }
        return yahooInterval;
    }
}
