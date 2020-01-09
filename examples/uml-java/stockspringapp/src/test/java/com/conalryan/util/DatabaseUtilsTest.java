package com.conalryan.util;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import static org.junit.Assert.assertNotNull;

/**
 *  Tests for the DatabaseUtils class
 */
public class DatabaseUtilsTest {

    @Test
    public void testGetSessionFactory() throws Exception {
        SessionFactory sessionFactory = DatabaseUtils.getSessionFactory();
        assertNotNull("verify that we can get session factory", sessionFactory);
    }

    @Test
    public void testGetConnection1() throws Exception {
        Connection connection = DatabaseUtils.getConnection();
        assertNotNull("verify that we can get a connection ok",connection);
    }

    @Test
    public void testInitializeDatabase() throws Exception {
        String initializationFile = "./src/main/sql/stockappdb_initialization.sql";
        DatabaseUtils.initializeDatabase(initializationFile);
        assertNotNull("verify the initialization script worked", initializationFile);
    }
}
