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
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sb.toString());
            System.out.println("Succeed");
        } catch (SQLException e) {
            e.printStackTrace();
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
        executePreparedStatement();
        executeInsert();
    }
}
