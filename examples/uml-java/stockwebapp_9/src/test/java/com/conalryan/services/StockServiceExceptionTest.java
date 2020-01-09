package com.conalryan.services;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;

public class StockServiceExceptionTest {

    @Test
    public void testDatabaseInitializationExceptionTest() {

        assertNotNull(new StockServiceException("Stock Service Error", new SQLException()));
    }
}