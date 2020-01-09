package com.conalryan.services;

import com.conalryan.model.Interval;
import com.conalryan.model.StockQuote;
import com.conalryan.util.DatabaseUtils;
import com.conalryan.util.QueryUtil;
import com.conalryan.xml.Stock;
import com.conalryan.xml.Stocks;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

/**
 * An implementation of the StockService interface that gets
 * stock data from a database.
 */
public class HibernateStockService implements StockService {

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws com.conalryan.services.StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    @SuppressWarnings("unchecked")
    public StockQuote getQuote(String symbol) throws StockServiceException {

        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<StockQuote> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(StockQuote.class);
            criteria.add(Restrictions.eq("symbol", symbol));

                   //.add(Restrictions.sqlRestriction("MAX(time)")); // produces SQL error
                   //.setProjection(Projections.max("date")); // produces SQL error
            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            returnValue = criteria.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockServiceException("Could not get Stock data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue.get(returnValue.size() - 1);
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws   com.conalryan.services.StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<StockQuote> getQuote(String symbol, DateTime from, DateTime until) throws StockServiceException {

        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<StockQuote> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(StockQuote.class);
            criteria.add(Restrictions.eq("symbol", symbol))
                    .add(Restrictions.ge("date", from))
                    .add(Restrictions.le("date", until));
            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            returnValue = criteria.list();
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockServiceException("Could not get Stock data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue;
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @param interval the interval for quotes eg. WEEKLY
     * @return a list of StockQuote instances
     * @throws   com.conalryan.services.StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<StockQuote> getQuote(String symbol, DateTime from, DateTime until, Interval interval) throws StockServiceException {

        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<StockQuote> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(StockQuote.class);
            criteria.add(Restrictions.eq("symbol", symbol))
                    .add(Restrictions.ge("date", from))
                    .add(Restrictions.le("date", until))
                    .add(Restrictions.sqlRestriction("'" + QueryUtil.createSqlRestriction(interval) + "'" ));
            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            returnValue = criteria.list();
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockServiceException("Could not get Stock data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue;
    }

    /**
     * Add a StockQuote to the database
     * @param stockQuote
     */
    public static void addStockQuote(StockQuote stockQuote) throws StockServiceException {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(stockQuote);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockServiceException("Unable to add StockQuote: " + stockQuote + " to database:" + e.getMessage());
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
            session.close();
        }
    }

    /**
     * Add a list of StockQuote to the database
     * @param stockQuotes
     */
    public static void addStockQuotes(Collection<StockQuote> stockQuotes) throws StockServiceException {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            for (StockQuote quote : stockQuotes) {
                StockQuote stockQuote = new StockQuote(quote);
                session.save(stockQuote);
            }
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockServiceException("Unable to add: stock quotes to database:" + e.getMessage());
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
            session.close();
        }
    }

    /**
     * Adds a Stocks object to the database
     * @param stocks
     * @throws com.conalryan.services.StockServiceException
     */
    public static void addStocksToDatabase(Stocks stocks) throws StockServiceException{
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            for (Stock stock : stocks.getStock()) {
                // prepare stock strings for StockQuote constructor
                BigDecimal price = new BigDecimal(stock.getPrice());
                DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
                DateTime dateTime = dateTimeFormatter.parseDateTime(stock.getTime());
                String symbol = stock.getSymbol();

                StockQuote stockQuote = new StockQuote(price, dateTime, symbol);
                session.save(stockQuote);
            }
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockServiceException("Unable to add stocks to database:" + e.getMessage());
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
            session.close();
        }
    }
}