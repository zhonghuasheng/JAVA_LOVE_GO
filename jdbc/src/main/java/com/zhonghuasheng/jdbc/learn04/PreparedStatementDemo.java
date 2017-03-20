package com.zhonghuasheng.jdbc.learn04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementDemo {
    private static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            String user = "postgres";
            String password = "postgres";
            String url = "jdbc:postgresql://localhost/jsp";
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private static void executePreparedStatement(int id) {
        Connection connection = getConnection();
        String sql = "SELECT * FROM public.company WHERE id > ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 3);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeBatch() {
        Connection connection = getConnection();
        String sql = "INSERT INTO public.company(id, name, age, address, salary) VALUES(?, ?, ?, ?, ?)";
        String deleteSql = "DELETE FROM public.company";

        try {
            // 只需要执行一次的Query使用Statement，只需要请求一次数据库连接，不需要预编译
            Statement statement = connection.createStatement();
            statement.executeUpdate(deleteSql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < 100; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, "Company " + i);
                preparedStatement.setInt(3, i);
                preparedStatement.setString(4, "Address " + i);
                preparedStatement.setInt(5, i);
                // 同一Query的多次执行使用PreparedStatement.addBatch能减少请求数据库连接的次数，从而提高性能
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

            preparedStatement.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            
        }
    }

    public static void main(String[] args) {
        executePreparedStatement(3);
        executeBatch();
    }
}
