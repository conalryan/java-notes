package com.conalryan.controller;

import com.conalryan.model.StockQuote;
import com.conalryan.services.StockService;
import com.conalryan.services.StockServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/quote")
public class QuoteController {

    private static StockService stockService;

    @Autowired
    public QuoteController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String quote(@RequestParam("symbol") String symbol, ModelMap model) throws StockServiceException {

        StockQuote stockquote = stockService.getQuote(symbol);
        model.addAttribute("quote", stockquote);

        return "quote";
    }

/*    @RequestMapping("/quotes")
    public String stockQuotes(@RequestParam Map<String,String> requestParams, ModelMap model) throws Exception{

        String symbol=requestParams.get("symbol");
        String from=requestParams.get("from");
        String to=requestParams.get("to");

        StockQuery stockQuery = new StockQuery(symbol, from, to);
        List<StockQuote> stockQuotes = stockService.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil());

        model.addAttribute("quotes", stockQuotes);

        return VIEW_INDEX;
    }

    @RequestMapping("/quotes/interval")
    public String stockQuotesInterval(@RequestParam Map<String,String> requestParams, ModelMap model) throws Exception{
        String symbol=requestParams.get("symbol");
        String from=requestParams.get("from");
        String to=requestParams.get("to");
        String interval=requestParams.get("interval").toUpperCase();

        StockQuery stockQuery = new StockQuery(symbol, from, to, interval);
        List<StockQuote> stockQuotes = stockService.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil());
        model.addAttribute("quoteInterval", stockQuotes);

        return VIEW_INDEX;
    }*/
}