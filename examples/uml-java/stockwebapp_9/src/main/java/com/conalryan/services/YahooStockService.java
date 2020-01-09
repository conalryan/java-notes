package com.conalryan.services;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Conal on 3/14/2015.
 */
public class YahooStockService {

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
    public Stock getQuote(String symbol) throws StockServiceException {

        Stock stock = null;
        try {
            stock = YahooFinance.get(symbol);
        } catch (NullPointerException e) {
            throw new StockServiceException("Could not get quote for " + symbol, e.getCause());
        } catch (Exception e) {
            throw new StockServiceException("Could not get quote for " + symbol, e.getCause());
        }

        return stock;
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
    public List<HistoricalQuote> getQuote(String symbol, Calendar from, Calendar until) throws StockServiceException {

        List<HistoricalQuote> historicalQuotes = null;

        try {
            Stock stock = YahooFinance.get(symbol);
            historicalQuotes = stock.getHistory(from, until);
        } catch (NullPointerException e) {
            throw new StockServiceException("Unable to get quotes for " + symbol, e.getCause());
        }

        return historicalQuotes;
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol   the stock symbol to search for
     * @param from     the date of the first stock quote
     * @param until    the date of the last stock quote
     * @param interval the interval of quotes to return. eg. Weekly, daily etc.
     * @return a list of StockQuote instances
     * @throws com.conalryan.services.StockServiceException if using the service generates an exception.
     *                                                      If this happens, trying the service may work, depending on the actual cause of the
     *                                                      error.
     */
    public List<HistoricalQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval) throws StockServiceException {

        List<HistoricalQuote> historicalQuotes = null;

        try {
            // get yahoo quotes list convert to stockQuote list
            Stock stock = YahooFinance.get(symbol);
            historicalQuotes = stock.getHistory(from, until, interval);
        } catch (NullPointerException e) {
            throw new StockServiceException("Unable to get quotes for " + symbol, e.getCause());
        }

        return historicalQuotes;
    }
}