package com.zhonghuasheng.jdbc.learn02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementsDemo {

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/jsp", "postgres", "postgres");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void executeInsert() {
        StringBuilder sb = new StringBuilder("INSERT INTO company(id, name, age, address, salary) VALUES (");
        sb.append(12);
        sb.append(", 'Company' ,");
        sb.append(0);
        sb.append(", 'Li Si Road' , ");
        sb.append(110);
        sb.append(");");

        Connection connection = getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sb.toString());
            System.out.println("Succeed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(connection, statement, null);
        }
    }

    public static void executeDelete() {
        Connection connection = getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            int result = statement.executeUpdate("DELETE FROM public.company WHERE id = 12;");
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(connection, statement, null);
        }
    }

    public static void executeUpdate() {
        Connection connection = getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            int i = statement.executeUpdate("UPDATE public.company SET name = 'abc' WHERE id = 1;");
            System.out.println(i); // 返回结果是1
            int j = statement.executeUpdate("UPDATE public.company SET name = 'abc' WHERE id = 12345;");
            System.out.println(j); // 返回结果是0
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(connection, statement, null);
        }
    }

    public static void executeSelect() {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM public.company;");

            while(resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(connection, statement, resultSet);
        }
    }

    public static void closeResource(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void executePreparedStatement() {
        String sql = "SELECT * FROM public.company WHERE id > ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 6);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }

            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Execute delete===");
        executeDelete();
        executePreparedStatement();
        System.out.println("Execute insert===");
        executeInsert();
        System.out.println("Execute update===");
        executeUpdate();
        System.out.println("Execute delete===");
        executeDelete();
        System.out.println("Execute select===");
        executeSelect();
    }
}
