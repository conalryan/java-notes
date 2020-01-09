package com.conalryan.apps.stockquote;

import com.conalryan.model.StockQuote;
import com.conalryan.services.StockServiceException;
import com.conalryan.services.YahooStockService;
import org.joda.time.DateTime;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Conal on 3/14/2015.
 */
public class MainScratchPad {

    public static void main(String[] args) {

        // YAHOO EXAMPLLES
        // 1
        Stock stock = YahooFinance.get("AAPL");
        BigDecimal price = stock.getQuote(true).getPrice();

        stock.print();

        System.out.println("mid test 1-----------------------------------------");

        // 1
        StockQuote stockQuote = null;

        YahooStockService service = new YahooStockService();
        try {
            stockQuote = new StockQuote(service.getQuote("AAPL"));
        } catch (StockServiceException e) {
            e.printStackTrace();
        }
        System.out.println(stockQuote.toString());

        System.out.println("========================================END TEST 1");

        // 2
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.MONTH, -1); // from 1 month ago

        Stock stock2 = YahooFinance.get("BAC");
        List<HistoricalQuote> stockHistQuotes = stock2.getHistory(from, to);

        for(HistoricalQuote quote : stockHistQuotes) {
            quote.toString();
        }

        System.out.println("mid test 2-----------------------------------------");

        // 2
        DateTime dateFrom = new DateTime(2015,2,13,0,0,0,0);
        DateTime dateTo = new DateTime();

        List<StockQuote> stockQuotes = new ArrayList<>();
        try {
            stockQuotes = service.getQuote("BAC", dateFrom, dateTo);
        } catch (StockServiceException e) {
            e.printStackTrace();
        }


        System.out.println("========================================END TEST 2");

        System.out.println(stockQuotes.toString());
        // 3
        Stock stock3 = YahooFinance.get("CME");
        List<HistoricalQuote> stockHistQuotes3 = stock3.getHistory(from, to, Interval.MONTHLY);

        System.out.println("mid test 3-----------------------------------------");

        // 3
        List<StockQuote> stockQuotes3 = new ArrayList<>();
        try {
            stockQuotes3 = service.getQuote("CME", dateFrom, dateTo, com.conalryan.model.Interval.MONTHLY);
        } catch (StockServiceException e) {
            e.printStackTrace();
        }

        System.out.println(stockQuotes3.toString());

        System.out.println("========================================END TEST 3");

    }
}
