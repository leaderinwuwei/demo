package com.captain.demo.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Captain Wang
 * @time2020/6/23
 */
public class JDBCUtils {
    private static final String driverClassName;
    private static final String url;
    private static final String username;
    private static final String password;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverClassName = properties.getProperty("driverClassName");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    public static void loadDriver() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        loadDriver();
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void release(PreparedStatement prep, Connection conn) throws SQLException {
        prep.close();
        conn.close();
    }

    public static void release(ResultSet rs, PreparedStatement prep, Connection conn) throws SQLException {
        rs.close();
        prep.close();
        conn.close();
    }

    public static void release(Statement statement, Connection conn) throws SQLException {
        statement.close();
        conn.close();
    }
}
