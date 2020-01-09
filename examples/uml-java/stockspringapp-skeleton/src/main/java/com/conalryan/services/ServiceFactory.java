package com.conalryan.services;

/**
 * A factory that returns a <CODE>StockService</CODE> instance.
 */
public class ServiceFactory {

    // Use singleton pattern
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
}
