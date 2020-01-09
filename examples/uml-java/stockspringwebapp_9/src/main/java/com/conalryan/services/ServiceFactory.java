package com.conalryan.services;

import com.conalryan.model.Stock;

/**
 * A factory that returns a <CODE>StockService</CODE> instance.
 */
public class ServiceFactory {

    // Use singleton pattern
    private static PersonService personService = new DatabasePersonService();
    //private static StockService stockService = new DatabaseStockService();
    //private static StockService stockService = new HibernateStockService();
    //private static StockService stockService = new SimpleStockService();
    private static StockService stockService = new YahooStockService();

    /**
     * Prevent instantiations
     */
    private ServiceFactory() {}

    /**
     * Get an instance of a StockService
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getStockServiceInstance() { return stockService; }

    /**
     * Get an instance of a PersonService
     */
    public static PersonService getPersonServiceInstance() { return personService; };
}
