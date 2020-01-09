package com.conalryan.util;

import com.conalryan.xml.Stock;
import com.conalryan.xml.Stocks;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for XML utils.
 */
public class XMLUtilsTest {

    private static String STOCK_NAME = "GOOG";
    private static String STOCK_PRICE = "700.10";
    private static String STOCK_TIME = "2015-02-10 00:00:01";

    private static String xmlStocks = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<stocks>\n" +
            "    <stock symbol=\"GCLT\" price=\"8.90\" time=\"2015-02-10 00:00:01\"/>\n" +
            "    <stock symbol=\"GOOG\" price=\"700.10\" time=\"2015-02-10 00:00:01\"/>\n" +
            "    <stock symbol=\"OTOW\" price=\"60.41\" time=\"2015-02-10 00:00:01\"/>\n" +
            "</stocks>";

    @Test
    public void testUnmarshall() throws Exception {
        Stocks stocks = XMLUtils.unmarshall(new File("src/main/resources/stock_info_test.xml"), Stocks.class);

        System.out.println(stocks.getStock().get(1).getSymbol());
        System.out.println(stocks.getStock().get(1).getPrice());
        System.out.println(stocks.getStock().get(1).getTime());

        assertEquals("Symbol is correct", stocks.getStock().get(1).getSymbol(), STOCK_NAME);
    }

    @Test
    public void testMarshall() throws Exception {
        /*
        <stock symbol="GCLT" price="8.90" time="2015-02-10 00:00:01"/>
        <stock symbol="GOOG" price ="700.10" time="2015-02-10 00:00:01"/>
        <stock symbol="OTOW" price="60.41" time="2015-02-10 00:00:01"/>
        */
        Stock stock = new Stock();
        stock.setSymbol("GCLT");
        stock.setPrice("8.90");
        stock.setTime("2015-02-10 00:00:01");

        Stock stock2 = new Stock();
        stock2.setSymbol("GOOG");
        stock2.setPrice("700.10");
        stock2.setTime("2015-02-10 00:00:01");

        Stock stock3 = new Stock();
        stock3.setSymbol("OTOW");
        stock3.setPrice("60.41");
        stock3.setTime("2015-02-10 00:00:01");

        List<Stock> stockList = new ArrayList<>();
        stockList.add(stock);
        stockList.add(stock2);
        stockList.add(stock3);

        Stocks stocks = new Stocks();
        stocks.setStock(stockList);

       // XMLUtils.marshall(Stocks.class);
        String xml = XMLUtils.marshall(stocks);
        System.out.println(xml);
        // input xml should be the same as output xml
        //assertEquals("XML out is correct", xml.trim() ,xmlStocks.trim());
    }
}