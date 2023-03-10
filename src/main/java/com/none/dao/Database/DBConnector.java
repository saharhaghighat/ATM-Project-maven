package com.none.dao.Database;

import com.none.utill.Method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.Properties;

import static com.none.dao.Database.DBConfig.loadDbproperties;

public class DBConnector {
    private static Connection connection=null;
    static {
        Properties properties=loadDbproperties("C:/Users/Dell/IdeaProjects/ATM/src/main/resources/db.properties");
        String url=properties.getProperty("MYSQLJDBC.url");
        String username= properties.getProperty("MYSQLJDBC.user");
        String password=properties.getProperty("MYSQLJDBC.password");
        try {
            connection= DriverManager.getConnection(url,username,password);
            if (Objects.nonNull(connection)){
                Method.print("Connect successfully!");
                DDL.setDataBase();}
            else
                Method.print("sorry!:(");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }


}
