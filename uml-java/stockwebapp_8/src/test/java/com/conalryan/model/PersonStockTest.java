package com.conalryan.model;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonStockTest {

    private int id;
    private Person person;
    private Stock stock;
    private PersonStock personStock;

    @Before
    public void setUp() throws Exception {
        id = 1;
        person = new Person("Conal", "Ryan", new DateTime(1980,12,25,0,0,0,0));
        stock = new Stock("Apple", "AAPL", "Nasdaq");
        personStock = new PersonStock(person, stock);
        personStock.setId(id);
    }

    @Test
    public void testPersonStock() throws Exception {assertNotNull("PersonStock created", personStock);}

    @Test
    public void testGetId() throws Exception { assertEquals("Id get is correct", id, personStock.getId()); }

    @Test
    public void testSetId() throws Exception {
        personStock.setId(22);
        assertEquals("id set is correct", 22, personStock.getId());
    }

    @Test
    public void testGetPerson() throws Exception { assertEquals("person get is correct", person, personStock.getPerson()); }

    @Test
    public void testSetPerson() throws Exception {
        Person person2 = new Person("Bob", "Smith", new DateTime(1981,9,19,0,0,0,0));
        personStock.setPerson(person2);
        assertEquals("person set is correct", person2, personStock.getPerson());
    }

    @Test
    public void testGetStock() throws Exception { assertEquals("stock get is correct", stock, personStock.getStock()); }

    @Test
    public void testSetStock() throws Exception {
        Stock stock2 = new Stock("Intel", "INTC", "Nasdaq");
        personStock.setStock(stock2);
        assertEquals("stock set correct", stock2, personStock.getStock());
    }

    @Test
    public void testEquals() throws Exception {
        int id2 = 1;
        Person person2 = new Person("Conal", "Ryan", new DateTime(1980,12,25,0,0,0,0));
        Stock stock2 = new Stock("Apple", "AAPL", "Nasdaq");
        PersonStock personStock2 = new PersonStock(person2, stock2);
        personStock2.setId(id);

        assertEquals("equals is correct", personStock2, personStock);
    }

    @Test
    public void testHashCode() throws Exception {
        int id2 = 1;
        Person person2 = new Person("Conal", "Ryan", new DateTime(1980,12,25,0,0,0,0));
        Stock stock2 = new Stock("Apple", "AAPL", "Nasdaq");
        PersonStock personStock2 = new PersonStock(person2, stock2);
        personStock2.setId(id);

        assertEquals("hashcode is correct", personStock2.hashCode(), personStock.hashCode());

    }

    @Test
    public void testToString() throws Exception { assertNotNull("toString is correct", personStock.toString()); }
}