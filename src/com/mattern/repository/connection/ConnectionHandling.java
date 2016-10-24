package com.mattern.repository.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * smattern on 09/10/16.
 */
public class ConnectionHandling {

    private static final Logger LOG = Logger.getLogger(ConnectionHandling.class.getSimpleName());
    private Connection conn;

    /**
     * Get defined database connection.
     *
     * @return the database connection
     */
    public Connection getConnection() {
        return conn;
    }

    /**
     * Define and open a database connection.
     */
    public void beginConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/SENDatabase?user=dev&password=dev&useSSL=false");
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            LOG.log(Level.INFO, "BUG!!!" + e.getMessage());
        }
    }

    /**
     * Close database connection.
     */
    public void endConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
