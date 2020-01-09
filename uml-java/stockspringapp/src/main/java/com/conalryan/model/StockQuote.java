package com.conalryan.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * A container class that contains stock data.
 */
@Entity
@Table(name="quotes")
public class StockQuote extends StockData {

    @Id
    @Column(name = "ID", nullable = false) //, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 256)
    private String symbol;

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true)
    private BigDecimal price;

    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime date;

    /**
     * Default constructor for Hibernate framework only
     */
    public StockQuote() {}

    /**
     * Create a new instance of a StockQuote.
     *
     * @param price  the share price for the given date
     * @param date   the date of the share price
     * @param symbol the stock symbol.
     */
    public StockQuote(BigDecimal price, DateTime date, String symbol) {
        super();
        this.price = price;
        this.date = date;
        this.symbol = symbol;
    }

    /**
     * Create a new instance of a StockQuote
     * @param stockQuote
     */
    public StockQuote(StockQuote stockQuote) {
        super();
        this.price = stockQuote.getPrice();
        this.date = stockQuote.getDate();
        this.symbol = stockQuote.getSymbol();
    }

    /**
     * @return Get the share price for the given date.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @return The date of the share price
     */
    public DateTime getDate() {
        return date;
    }

    /**
     * @return The stock symbol.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Overriding the equals method
     * If the symbol, price and date are the same return true
     * @param o StockQuote object
     * @return true if the symbol, price and date are the same for both objects
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockQuote that = (StockQuote) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;

        return true;
    }

    /**
     * Overriding the hashcode method so equals will return true if
     * symbol, price and date are the same for a given StockQuote
     * @return int hashCode
     */
    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String dateString = dateTimeFormatter.print(date);
        return "StockQuote{" +
                "price=" + price +
                ", date=" + dateString +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}