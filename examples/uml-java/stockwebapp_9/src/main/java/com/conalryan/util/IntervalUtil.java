package com.conalryan.util;

import com.conalryan.model.Interval;

/**
 * Created by Conal on 3/14/2015.
 * Class is used to convert Interval enums
 */
public class IntervalUtil {

    /**
     * Converts a String to an Interval
     *
     * @param string
     * @return Interval
     */
    public static Interval convertStringToInterval(String string) {

        Interval interval = null;

        switch(string.toUpperCase()) {

            case "MONTHLY":
                interval = Interval.MONTHLY;
                break;
            case "WEEKLY":
                interval = Interval.WEEKLY;
                break;
            case "DAILY":
                interval = Interval.DAILY;
                break;
        }
        return interval;
    }

    /**
     * Converts an Interval to a Yahoo Finance Interval
     *
     * @param interval
     * @return yahoofinance.histquotes.Interval
     */
    public static yahoofinance.histquotes.Interval convertIntervalToYahooInterval(Interval interval) {

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

    /**
     * Converts a yahooInterval to an Interval
     *
     * @param yahooInterval
     * @return interval
     */
    public static Interval convertYahooIntervalToInterval(yahoofinance.histquotes.Interval yahooInterval) {

        Interval interval = null;

        switch(yahooInterval) {

            case MONTHLY:
                interval = Interval.MONTHLY;
                break;
            case WEEKLY:
                interval = Interval.WEEKLY;
                break;
            case DAILY:
                interval = Interval.DAILY;
                break;
        }
        return interval;
    }
}