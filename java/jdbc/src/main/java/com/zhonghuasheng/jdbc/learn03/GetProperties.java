package com.zhonghuasheng.jdbc.learn03;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetProperties {
    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            System.out.println("Succeed");
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        InputStream inputStream = GetProperties.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(inputStream);
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(driver);

        return DriverManager.getConnection(url, user, password);
    }
}
