package com.jsp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static final String driver = "";
    private static final String url = "jdbc:postgresql://localhost/jsp";
    private static final String user = "postgres";
    private static final String password = "postgres";
    private static Connection conn = null;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }
}
