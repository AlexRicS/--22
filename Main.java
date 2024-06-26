package com.devcolibri.based;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/bases";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "alex";

    public static void main(String[] args){
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);

        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM cars");
                System.out.println("Выберите машину:");
                int index = 1;
                while (resultSet.next()) {
                    System.out.println(index + ". " + resultSet.getString("car_name"));
                    index++;
                }
                System.out.print("Введите номер машины: ");
                int choice = scanner.nextInt();
                resultSet.beforeFirst();
                index = 1;
                while (resultSet.next()) {
                    if (index == choice) {
                        System.out.println("Вы выбрали машину: " + resultSet.getString("car_name"));
                        break;
                    }
                    index++;
                }
                resultSet.close();
                statement.close();
            }

        } catch (SQLException e) {
            System.err.println("Не удалось установить соединение: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    if (connection.isClosed()) {
                        System.out.println("Соединение закрыто");
                    }
                } catch (SQLException e) {
                    System.err.println("Не удалось закрыть соединение: " + e.getMessage());
                }
            }
        }

        scanner.close();
    }
}
