package com.conalryan.util;

import junit.framework.TestCase;
import org.junit.Test;

import java.sql.SQLException;

public class DatabaseConnectionExceptionTest extends TestCase {

    @Test
    public void testDatabaseConnectionException() {
        assertNotNull(new DatabaseConnectionException("DB Error", new SQLException()));
    }
}