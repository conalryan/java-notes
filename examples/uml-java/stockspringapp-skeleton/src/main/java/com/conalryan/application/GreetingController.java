package com.conalryan.application;

import com.conalryan.model.StockQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/users")
    public String saveUser(@RequestParam Map<String,String> requestParams) throws Exception{
        String userName=requestParams.get("email");
        String password=requestParams.get("password");

        //perform DB operations

        return userName;
    }

    @RequestMapping("/fakequote")
    //public List<StockQuote> stockQuotes(@RequestParam Map<String,String> requestParams) throws Exception{
    public List<String> stockQuotes(@RequestParam Map<String,String> requestParams) throws Exception{

        String symbol=requestParams.get("symbol");
        String from=requestParams.get("from");
        String to=requestParams.get("to");

        List<String> list = new ArrayList<>();
        list.add(symbol);
        list.add(from);
        list.add(to);

        StockQuery stockQuery = new StockQuery(symbol, from, to);
        //   return stockSerivce.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil());
        return list;
    }

}
