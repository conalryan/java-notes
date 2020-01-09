package com.conalryan.controller;

import com.conalryan.model.Interval;
import com.conalryan.model.StockQuery;
import com.conalryan.model.StockQuote;
import com.conalryan.services.ServiceAdapter;
import com.conalryan.services.ServiceFactory;
import com.conalryan.services.StockService;
import com.conalryan.services.StockServiceException;
import com.conalryan.util.IntervalUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class QuoteController {

    private static StockService stockService = ServiceFactory.getStockServiceInstance();
    private static final String QUOTE_VIEW = "quote";

    @RequestMapping(value = "/yahoo/quote", method = RequestMethod.GET)
    public String yahooQuote(@RequestParam("symbol") String symbol, ModelMap model) throws StockServiceException {

        StockQuote stockquote = ServiceAdapter.getServiceAdapterInstance().getQuote(symbol);
        model.addAttribute("quote", stockquote);

        return QUOTE_VIEW;
    }


    @RequestMapping("/yahoo/quotes/interval")
    public String yahooQuotesInterval(@RequestParam Map<String, String> requestParams, ModelMap model) throws Exception {

        String symbol = requestParams.get("stocksymbol");
        String from = requestParams.get("from");
        String until = requestParams.get("until");
        String interval = requestParams.get("interval").toUpperCase();

        StockQuery stockQuery = new StockQuery(symbol, from, until, interval);

        List<StockQuote> stockQuotes = ServiceAdapter.getServiceAdapterInstance().getQuote
                (stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil(), stockQuery.getInterval());

        System.out.println("SIZE" + stockQuotes.size());
        System.out.println("QUOTES " + stockQuotes.get(0).getSymbol());
        System.out.println("QUOTES " + stockQuotes.get(0).getPrice());
        System.out.println("QUOTES " + stockQuotes.get(0).getDate());

        //model.addAttribute("quotes", stockQuotes);
        model.addAllAttributes(stockQuotes);

        return QUOTE_VIEW;
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public String quote(@RequestParam("symbol") String symbol, ModelMap model) throws StockServiceException {

        StockQuote stockquote = stockService.getQuote(symbol);
        model.addAttribute("quote", stockquote);

        return QUOTE_VIEW;
    }

    @RequestMapping("/quotes/interval")
    public String stockQuotesInterval(@RequestParam Map<String, String> requestParams, ModelMap model) throws Exception {

        String symbol = requestParams.get("symbol");
        String from = requestParams.get("from");
        String until = requestParams.get("until");
        String interval = requestParams.get("interval").toUpperCase();

        StockQuery stockQuery = new StockQuery(symbol, from, until, interval);
        List<StockQuote> stockQuotes = stockService.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil());
        model.addAttribute("quotes", stockQuotes);

        return QUOTE_VIEW;
    }
}