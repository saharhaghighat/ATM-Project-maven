package com.none.dao.Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
    public static Properties loadDbproperties(String path){
        Properties properties=new Properties();
        InputStream inputStream;
        try {
            inputStream=new FileInputStream(path);
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
