package com.mea.happyclients.database;

import com.mea.happyclients.errors.ErrorList;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Manages data creation, retreival and management.
 */
public class DatabaseLayer {

    private static DatabaseLayer dbLayer = null;

    private BasicDataSource ds;

    private DatabaseLayer() {
        init();
    }

    private void init() {
        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("happyclients");
        ds.setPassword("password");
        ds.setUrl("jdbc:mysql://localhost/happyclients?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

        // the settings below are optional -- dbcp can work with defaults
        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return connection;
    }

    public static DatabaseLayer getInstance() {
        if (dbLayer == null) {
            dbLayer = new DatabaseLayer();
        }

        return dbLayer;
    }

    public ErrorList createUserInDB(String email, String password) {
        ErrorList errorList = new ErrorList();

        String query = "INSERT INTO users\n" +
                "(`email`,`password`) \n VALUES \n" +
                "('" + email + "', '" + password + "');";

        int id = executeInsert(query);

        return errorList;
    }

    private int executeInsert(String query) {
        return executeInsert(query, null);
    }

    private int executeInsert(String query, String idColumnName) {

        int result = -1;

        Connection conn = getConnection();
        if (idColumnName == null) {
            idColumnName = "id";
        }

        try {
            Statement stmt = conn.createStatement();
            int count = stmt.executeUpdate(query, new String[]{idColumnName});
            if (count > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                result = rs.getInt(1);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean businessExists(String businessName) {
        return false;
    }


}
