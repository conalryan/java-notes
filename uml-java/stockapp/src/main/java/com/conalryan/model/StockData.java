package com.conalryan.model;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


/**
 * Abstract Base class for classes that hold Stock data.
 * Provides common code for such classes including date formatting.
 */
public abstract class StockData {

    /**
     * Provide a single SimpleDateFormat for consistency
     * and to avoid duplicated code.
     */
    //protected static SimpleDateFormat simpleDateFormat;

    /**
     * Provide a single DateTimeFormat for consistency
     * and to avoid duplicated code.
     */
    protected static DateTimeFormatter dateTimeFormatter;

    /**
     * Base constructor for StockData classes.
     * Initialize member data that is shared with sub classes.
     */
   // public StockData() { simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd"); }
    public StockData() { dateTimeFormatter = DateTimeFormat.forPattern("yyyy/MM/dd"); }
}