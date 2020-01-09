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
 * Created by Conal on 4/4/2015.
 */
public class ServiceAdapter implements StockService {

    private static YahooStockService yahooStockService = new YahooStockService();
    private static ServiceAdapter serviceAdapter = new ServiceAdapter();

    // stop instantiatiation
    private ServiceAdapter() {}

    /**
     * Get an instance of the service adapter
     *
     * @return ServiceAdapter
     */
    public static ServiceAdapter getServiceAdapterInstance() { return serviceAdapter; }

    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {

        StockQuote stockQuote = null;
        try {
            Stock stock = yahooStockService.getQuote(symbol);
            // convert stock to stockquote
            BigDecimal price = stock.getQuote().getPrice();
            DateTime dateTime = new DateTime(stock.getQuote().getLastTradeTime());
            String stockSymbol = stock.getSymbol();
            stockQuote = new StockQuote(price, dateTime, stockSymbol);
        } catch (NullPointerException e) {
            throw new StockServiceException("Could not get quote for " + symbol, e.getCause());
        }

        return stockQuote;
    }

    @Override
    public List<StockQuote> getQuote(String symbol, DateTime from, DateTime until) throws StockServiceException {

        // joda time to calendar
        Calendar calendarFrom = convertJodaTimeToCalendar(from);
        Calendar calendarUntil = convertJodaTimeToCalendar(until);

        // call the service
        List<HistoricalQuote> historicalQuotes = yahooStockService.getQuote(symbol, calendarFrom, calendarUntil);

        // convert yahoo quotes to stockQuotes and return
        return convertHistoricalQuotesToStockQuotes(historicalQuotes);
    }

    @Override
    public List<StockQuote> getQuote(String symbol, DateTime from, DateTime until, Interval interval)
            throws StockServiceException {

        // joda time to calendar
        Calendar calendarFrom = convertJodaTimeToCalendar(from);
        Calendar calendarUntil = convertJodaTimeToCalendar(until);

        // convert interval to yahoo.interval
        yahoofinance.histquotes.Interval yahooInterval = IntervalUtil.convertIntervalToYahooInterval(interval);

        // call the service
        List<HistoricalQuote> historicalQuotes = yahooStockService.getQuote(symbol, calendarFrom, calendarUntil, yahooInterval);

        // convert yahoo quotes to stockQuotes and return
        return convertHistoricalQuotesToStockQuotes(historicalQuotes);
    }

    private Calendar convertJodaTimeToCalendar(DateTime date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date.toDate());
        return calendar;
    }

    private List<StockQuote> convertHistoricalQuotesToStockQuotes(List<HistoricalQuote> historicalQuotes)
            throws StockServiceException {

        // convert yahoo quotes to stockQuotes
        List<StockQuote> stockQuotes = null;
        String stockSymbol = "";
        try {
            stockQuotes = new ArrayList<>();

            for(HistoricalQuote quote : historicalQuotes) {
                BigDecimal price = quote.getClose();
                DateTime dateTime = new DateTime(quote.getDate());
                stockSymbol = quote.getSymbol();
                StockQuote stockQuote = new StockQuote(price, dateTime, stockSymbol);
                stockQuotes.add(stockQuote);
            }
        } catch (NullPointerException e) {
            throw new StockServiceException("Unable to get quotes for " + stockSymbol, e.getCause());
        }

        return stockQuotes;
    }
}
