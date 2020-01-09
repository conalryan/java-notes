package com.conalryan.controller;

import com.conalryan.model.StockQuery;
import com.conalryan.model.StockQuote;
import com.conalryan.services.ServiceFactory;
import com.conalryan.services.StockService;
import com.conalryan.services.StockServiceException;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.conalryan.services.YahooStockService;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockQuoteController {

    private static final StockService stockSerivce = ServiceFactory.getStockServiceInstance();

    @RequestMapping("/quote")
    public StockQuote stockQuote(@RequestParam("symbol") String symbol) throws StockServiceException {
        return stockSerivce.getQuote(symbol);
    }

    @RequestMapping("/quotes")
    public List<StockQuote> stockQuotes(@RequestParam Map<String,String> requestParams) throws Exception{

        String symbol=requestParams.get("symbol");
        String from=requestParams.get("from");
        String to=requestParams.get("to");

        StockQuery stockQuery = new StockQuery(symbol, from, to);
        return stockSerivce.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil());
    }


    @RequestMapping("/quotes/interval")
    public List<StockQuote> stockQuotes2(@RequestParam Map<String,String> requestParams) throws Exception{
        String symbol=requestParams.get("symbol");
        String from=requestParams.get("from");
        String to=requestParams.get("to");
        String interval=requestParams.get("interval").toUpperCase();

        StockQuery stockQuery = new StockQuery(symbol, from, to, interval);
        return stockSerivce.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil());
    }

    @RequestMapping("/yatest")
    public List<StockQuote> yaTest(@RequestParam Map<String,String> requestParams) throws Exception{
        String symbol=requestParams.get("symbol");
        String from=requestParams.get("from");
        String to=requestParams.get("to");

        YahooStockService yahooStockService = new YahooStockService();

        StockQuery stockQuery = new StockQuery(symbol, from, to);
        return yahooStockService.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil());
    }
}
