package com.conalryan.controller;

import com.conalryan.model.StockQuery;
import com.conalryan.model.StockQuote;
import com.conalryan.services.ServiceFactory;
import com.conalryan.services.StockService;
import com.conalryan.services.StockServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class QuoteController {

    private static StockService stockService = ServiceFactory.getStockServiceInstance();
    private static final String VIEW_INDEX = "quote";

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public String quote(@RequestParam("symbol") String symbol, ModelMap model) throws StockServiceException {

        StockQuote stockquote = stockService.getQuote(symbol);
        model.addAttribute("quote", stockquote);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;
    }

    @RequestMapping("/quotes")
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
    }
}