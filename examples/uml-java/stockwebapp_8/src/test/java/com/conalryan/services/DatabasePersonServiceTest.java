package com.conalryan.services;

import com.conalryan.model.Person;
import com.conalryan.model.Stock;
import com.conalryan.util.DatabaseUtils;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabasePersonServiceTest {

    private PersonService personService;
    private Person person;
    private Stock stock;

    @Before
    public void setUp() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
        personService = ServiceFactory.getPersonServiceInstance();
        person = new Person("Conal", "Ryan", new DateTime(1980,12,25,0,0,0,0));
        stock = new Stock("Apple", "AAPL", "Nasdaq");
    }

    @Test
    public void testGetPerson() throws Exception {
        assertNotNull("Got person's from db", personService.getPerson());
    }

    @Test
    public void testAddOrUpdatePerson() throws Exception {
        String placeHolder = "no error thrown";
        personService.addOrUpdatePerson(person);
        assertNotNull("Call update person method", placeHolder);
    }

    @Test
    public void testGetStocks() throws Exception {
        assertNotNull("Get stocks drom db", personService.getStocks(person));
    }

    @Test
    public void testAddStockToPerson() throws Exception {
        String placeHolder = "no error thrown";
        personService.addStockToPerson(stock, person);
        assertNotNull("update stock with person", placeHolder);
    }
}