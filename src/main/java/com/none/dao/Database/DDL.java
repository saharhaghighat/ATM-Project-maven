package com.none.dao.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.none.dao.Database.DBConfig.loadDbproperties;

public class DDL {
    static Properties properties = loadDbproperties("C://Users//Dell//IdeaProjects//ATM//src//main//resources//ddl.properties");

    private static final String dbCheck = properties.getProperty("dbCheck");

    private static final String tableCheck = properties.getProperty("tableCheck");

    private static final String selectDb = properties.getProperty("selectDb");

    private static final String createDb = properties.getProperty("createDb");

    private static final String createAccount = properties.getProperty("createAccount");

    private static final String createUser = properties.getProperty("createUser");

    private static final String createTransaction = properties.getProperty("createTransaction");

    private static final String createCard = properties.getProperty("createCard");

    private static boolean dbExist(String dbName) {
        Connection connection = DBConnector.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(dbCheck)) {
            preparedStatement.setString(1, dbName);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) != 0;


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private static boolean tableExist(String tableName) {
        Connection connection = DBConnector.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("tableCheck")) {
            preparedStatement.setString(1, tableName);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void createDb() {
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createDb);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void createAccount() {
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createAccount);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void createUser() {
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createUser);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private static void createTransaction() {
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createTransaction);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private static void createCard() {
        Connection connection = DBConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createCard);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private static void useDb(){
        Connection connection=DBConnector.getConnection();
        try (PreparedStatement preparedStatement=connection.prepareStatement(selectDb)){
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void setDataBase(){
        if (dbExist("atm"))
            createDb();
        if ((!tableExist("Card")))
            createCard();
        if (!tableExist("Account"))
            createAccount();
        if ((!tableExist("User")))
            createUser();
        if ((!tableExist("Transaction")))
            createTransaction();
    }



}
