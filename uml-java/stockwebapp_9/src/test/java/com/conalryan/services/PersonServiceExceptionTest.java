package com.conalryan.services;

import org.junit.Test;
import java.sql.SQLException;
import static org.junit.Assert.assertNotNull;

public class PersonServiceExceptionTest {

    @Test
    public void testDatabaseInitializationExceptionTest() {

        assertNotNull(new PersonServiceException("Person Service Error", new SQLException()));
    }
}