package com.conalryan.services;

import com.conalryan.model.Interval;
import com.conalryan.model.StockQuote;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * An implementation of the StockService that returns hard coded data.
 */
public class SimpleStockService implements StockService {

    private BigDecimal price = new BigDecimal(100);
    private DateTime date = new DateTime(2005, 3, 26, 12, 0, 0, 0);;
    private String stock = "aapl";

    public StockQuote getQuote(String symbol) {
        // a dead simple implementation.
        return new StockQuote(price, date, stock);
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, DateTime from, DateTime until) {
        // a dead simple implementation.
        List<StockQuote> stockQuotes = new ArrayList<>();
        while (until.isAfter(from)) {
            stockQuotes.add(new StockQuote(new BigDecimal(100), from, symbol));
            from.plusDays(1);
        }
        return stockQuotes;
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol   the stock symbol to search for
     * @param from     the date of the first stock quote
     * @param until    the date of the last stock quote
     * @param interval
     * @return a list of StockQuote instances
     * @throws com.conalryan.services.StockServiceException if using the service generates an exception.
     *                                                      If this happens, trying the service may work, depending on the actual cause of the
     *                                                      error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, DateTime from, DateTime until, Interval interval) throws StockServiceException {
        return null;
    }
}
