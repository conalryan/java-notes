package com.conalryan.controller;

import com.conalryan.model.StockQuery;
import com.conalryan.model.StockQuote;
import com.conalryan.services.ServiceFactory;
import com.conalryan.services.StockService;
import com.conalryan.services.StockServiceException;
import java.text.ParseException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockQuoteController {

    private static final StockService stockSerivce = ServiceFactory.getStockServiceInstance();

    @RequestMapping("/quote")
    public StockQuote stockQuote(@RequestParam(value="symbol") String symbol) throws StockServiceException {
        return stockSerivce.getQuote(symbol);
    }

    @RequestMapping("/quote")
    public List<StockQuote> stockQuote(@RequestParam(value="symbol") String symbol,
                                 @RequestParam(value="from") String from,
                                 @RequestParam(value="until") String until)
            throws StockServiceException, ParseException {
        StockQuery stockQuery = new StockQuery(symbol, from, until);
        return stockSerivce.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil());
    }

    @RequestMapping("/quote")
    public List<StockQuote> stockQuote(@RequestParam(value="symbol") String symbol,
                                 @RequestParam(value="from") String from,
                                 @RequestParam(value="until") String until,
                                 @RequestParam(value="interval") String interval)
            throws StockServiceException, ParseException {
        StockQuery stockQuery = new StockQuery(symbol, from, until, interval);
        return stockSerivce.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil(), stockQuery.getInterval());
    }
}
