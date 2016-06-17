package com.mea.happyclients.database;

import com.mea.happyclients.errors.ErrorList;
import com.mea.happyclients.errors.Errors;
import com.mea.happyclients.infrastructure.Utils;
import com.mea.happyclients.users.User;
import com.mea.happyclients.users.plans.Plan;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.mea.happyclients.errors.Errors.*;

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
        //ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
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

        //Carry out preliminary checks
        if (userWithEmailExists(email)) {
            errorList.addError(ERR_DB_DUPLICATE_ENTRY, "A user with that e-mail address already exists.");
        }

        if (errorList.isOk()) {

            String query = "INSERT INTO users\n" +
                    "(`email`,`password`, `subscriptionDate`) \n VALUES \n" +
                    "('" + email + "', '" + password + "', curdate());";

            int id = executeInsert(query);

            if (id <= 0) {
                errorList.addError(ERR_DB_UNKOWN, "Unknown error occurred when creating user.");
            }

        }

        return errorList;
    }

    private int executeInsert(String query) {
        return executeInsert(query, null);
    }

    private ResultSet executeQuery(String query) {

        ResultSet rs = null;

        try {
            Connection conn = getConnection();
            rs = conn.createStatement().executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
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

    public boolean userWithEmailExists(String email) {

        boolean result = false;

        try {
            ResultSet rs = executeQuery("select count(*) from users where email='" + email + "';");
            rs.next();
            result = rs.getInt(1) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public User getUserByEmail(String email) {
        User user = null;

        try {
            ResultSet rs = executeQuery("select * from users where email='" + email + "';");
            if (rs.next()) {
                user = new User();
                user.setEmail(rs.getString("email"));
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPlan(Plan.getPlanByName(rs.getString("plan")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean userLogin(String email, String password) {
        boolean result = false;

        try {
            ResultSet rs = executeQuery("select count(*) from users where email='" + email
                    + "' and password='" + Utils.encodePassword(password) + "';");
            rs.next();
            result = rs.getInt(1) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


}
