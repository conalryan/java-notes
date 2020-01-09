package com.conalryan.model;

import javax.persistence.*;

/**
 * Models the Stocks_copy table
 */
@Entity
@Table(name="stocks")
public class Stock {

    private int id;
    private String companyName;
    private String tickerSymbol;

    /**
     * Default constructor for Hibernate framework only
     */
    public Stock() {}

    /**
     * Create a stock object
     * @param companyName string
     * @param tickerSymbol string
     * @param exchange string
     */
    public Stock(String companyName, String tickerSymbol, String exchange) {
        this.companyName = companyName;
        this.tickerSymbol = tickerSymbol;
        this.exchange = exchange;
    }

    private String exchange;

    /**
     * Primary Key - Unique ID for a particular row in the stock table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false) //, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the stocks table.
     * This method should not be called by client code. The value is managed internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the company's name
     */
    @Basic
    @Column(name = "company_name", nullable = false, insertable = true, updatable = true, length = 256)
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Specify the company's name
     * @param companyName a String value
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    /**
     * Specify the company's ticker symbol
     * @param tickerSymbol a String value
     */
    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    /**
     *
     * @return the company's ticker symbol
     */
    @Basic
    @Column(name = "ticker_symbol", nullable = false, insertable = true, updatable = true, length = 256)
    public String getTickerSymbol() {
        return tickerSymbol;
    }

    /**
     *
     * @return exchange a String value
     */
    public String getExchange() { return exchange; }

    /**
     *
     * @param exchange
     */
    public void setExchange(String exchange) { this.exchange = exchange; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (!companyName.equals(stock.companyName)) return false;
        if (!exchange.equals(stock.exchange)) return false;
        if (!tickerSymbol.equals(stock.tickerSymbol)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyName.hashCode();
        result = 31 * result + tickerSymbol.hashCode();
        result = 31 * result + exchange.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", tickerSymbol='" + tickerSymbol + '\'' +
                ", exchange='" + exchange + '\'' +
                '}';
    }
}
