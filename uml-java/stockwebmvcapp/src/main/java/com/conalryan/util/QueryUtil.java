package com.conalryan.util;

import com.conalryan.model.Interval;
import com.conalryan.model.StockData;
import com.conalryan.model.StockQuery;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Conal on 2/23/2015.
 * This class is used to Store SQL Queries
 */
public class QueryUtil {

    /**
     * Stop instantiation
     */
    private QueryUtil() {}

    /**
     * Creates a database query based on the data given
     * @param symbol String of a stock symbol eg. "AAPL"
     * @param from Calendar get quotes starting from the date
     * @param until Calendar get quotes up to this date
     * @param interval Enum interval period eg. MONTHLY, WEEKLY, DAILY
     * @return <code>String</code> Query string used against a SQL database
     */
    public static String createQuery(@NotNull String symbol, @NotNull DateTime from, @NotNull DateTime until, @NotNull Interval interval) {

        String queryString = null;
        // format dates to pass to db query
        //SimpleDateFormat dateFormat = StockQuery.getFormat(); // throws nullpointer in test
        //SimpleDateFormat dateFormat = StockData.getFormat(); // thows nullpointer in test
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy/MM/dd");
        String fromAsString = dateTimeFormatter.print(from);
        String untilAsString = dateTimeFormatter.print(until);

        switch(interval) {

            case ALL:
                queryString = "select symbol, price, time from quotes where symbol = '" + symbol + "' AND time >= '" + fromAsString + "' AND time <= '" + untilAsString + "' ORDER BY time";
                break;

            case MONTHLY:
                queryString = "SELECT symbol, price, time FROM quotes WHERE symbol = '" + symbol + "' AND time >= '" + fromAsString + "' AND time <= '" + untilAsString + "' AND time = LAST_DAY(time) ORDER BY time";
                break;

            case WEEKLY:
                queryString = "SELECT symbol, price, time FROM quotes WHERE symbol = '" + symbol + "' AND time >= '" + fromAsString + "' AND time <= '" + untilAsString + "' AND DAYOFWEEK(time) = 6 ORDER BY time";
                break;

            case DAILY:
                queryString = "SELECT symbol, price, time FROM quotes WHERE symbol = '" + symbol + "' AND time >= '" + fromAsString + "' AND time <= '" + untilAsString + "' AND HOUR(time) = 16 ORDER BY time";
                break;

            case CASH_SESSION:
                queryString = "SELECT symbol, price, time FROM quotes WHERE symbol = '" + symbol + "' AND time >= '" + fromAsString + "' AND time <= '" + untilAsString + "' AND TIME(time) >= 09:30:00 AND TIME(time) <= 16:00:00 ORDER BY time";
                break;
        }

        return queryString;
    }

    public static String createSqlRestriction (Interval interval) {

        String queryString = null;

        switch(interval) {

            case ALL:
                queryString = "ORDER BY time";
                break;

            case MONTHLY:
                queryString = "time = LAST_DAY(time) ORDER BY time";
                break;

            case WEEKLY:
                queryString = "DAYOFWEEK(time) = 6 ORDER BY time";
                break;

            case DAILY:
                queryString = "HOUR(time) = 16 ORDER BY time";
                break;

            case CASH_SESSION:
                queryString = "TIME(time) >= 093000 AND TIME(time) <= 160000 ORDER BY time";
                break;
        }

        return queryString;
    }
}
