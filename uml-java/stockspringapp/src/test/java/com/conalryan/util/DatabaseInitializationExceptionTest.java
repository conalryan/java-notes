package com.conalryan.util;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;

public class DatabaseInitializationExceptionTest {

    @Test
    public void testDatabaseInitializationExceptionTest() {

        assertNotNull(new DatabaseInitializationException("db Init Error", new SQLException()));
    }
}