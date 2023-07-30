package com.notelysia.emailclient.sqlitehelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;

public class SQLiteHelper {
    private final static org.apache.logging.log4j.Logger logger = LogManager.getLogger(SQLiteHelper.class);
    public static Connection getConnection() {
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:database/database.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec        
        }
        catch(SQLException ex)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            logger.error("Exceptions happen: " + ex, ex);
        }      
        return connection;
    }    
}
