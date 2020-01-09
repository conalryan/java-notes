package com.conalryan.services;

import com.conalryan.model.Interval;
import com.conalryan.model.StockQuote;
import com.conalryan.util.IntervalUtil;
import org.joda.time.DateTime;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Conal on 3/14/2015.
 */
public class YahooStockService implements StockService {
    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws com.conalryan.services.StockServiceException if using the service generates an exception.
     *                                                      If this happens, trying the service may work, depending on the actual cause of the
     *                                                      error.
     */
    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {

        StockQuote stockQuote = null;
        try {
            Stock stock = YahooFinance.get(symbol);
            BigDecimal price = stock.getQuote().getPrice();
            DateTime dateTime = new DateTime(stock.getQuote().getLastTradeTime());
            stockQuote = new StockQuote(price, dateTime, symbol);
        } catch (NullPointerException e) {
            throw new StockServiceException("Could not get quote for " + symbol, e.getCause());
        } catch (Exception e) {
            throw new StockServiceException("Could not get quote for " + symbol, e.getCause());
        }

        return stockQuote;
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws com.conalryan.services.StockServiceException if using the service generates an exception.
     *                                                      If this happens, trying the service may work, depending on the actual cause of the
     *                                                      error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, DateTime from, DateTime until) throws StockServiceException {

        // joda time to calendar
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime(from.toDate());
        Calendar calendarTo = Calendar.getInstance();
        calendarTo.setTime(until.toDate());
        List<StockQuote> stockQuotes = null;

        try {
            // get yahoo quotes list convert to stockQuote list
            Stock stock = YahooFinance.get(symbol);
            List<HistoricalQuote> historicalQuotes = stock.getHistory(calendarFrom, calendarTo);
            stockQuotes = new ArrayList<>();

            for(HistoricalQuote quote : historicalQuotes) {
                BigDecimal price = stock.getQuote().getPrice();
                DateTime dateTime = new DateTime(stock.getQuote().getLastTradeTime());
                StockQuote stockQuote = new StockQuote(price, dateTime, symbol);
                stockQuotes.add(stockQuote);
            }
        } catch (NullPointerException e) {
            throw new StockServiceException("Unable to get quotes for " + symbol, e.getCause());
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

        // joda time to calendar
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime(from.toDate());
        Calendar calendarTo = Calendar.getInstance();
        calendarTo.setTime(until.toDate());
        List<StockQuote> stockQuotes = null;

        // convert interval
        yahoofinance.histquotes.Interval yahooInterval = IntervalUtil.convertInterval(interval);

        try {
            // get yahoo quotes list convert to stockQuote list
            Stock stock = YahooFinance.get(symbol);
            List<HistoricalQuote> historicalQuotes = stock.getHistory(calendarFrom, calendarTo, yahooInterval);
            stockQuotes = new ArrayList<>();

            for(HistoricalQuote quote : historicalQuotes) {
                BigDecimal price = stock.getQuote().getPrice();
                DateTime dateTime = new DateTime(stock.getQuote().getLastTradeTime());
                StockQuote stockQuote = new StockQuote(price, dateTime, symbol);
                stockQuotes.add(stockQuote);
            }
        } catch (NullPointerException e) {
            throw new StockServiceException("Unable to get quotes for " + symbol, e.getCause());
        }

        return stockQuotes;
    }
}
