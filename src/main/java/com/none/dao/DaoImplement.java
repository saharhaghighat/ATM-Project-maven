package com.none.dao;

import com.none.dao.Database.DBConnector;
import com.none.domain.Account;

import java.sql.Connection;

public abstract class DaoImplement<T> implements Dao<T> {
    protected Connection connection= DBConnector.getConnection();

}
