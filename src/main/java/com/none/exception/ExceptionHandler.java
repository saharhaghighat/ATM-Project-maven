package com.none.exception;

import com.none.utill.Method;

import java.sql.SQLException;

public class ExceptionHandler {
    public static void handleException(Exception exception){
        if (exception instanceof SQLException) {
            SQLException sqlException = (SQLException) exception;

            Method.print("Error code:" + sqlException.getErrorCode());

            Method.print("SQL state:" + sqlException.getSQLState());
        }
        Method.print("Exception message:" + exception.getMessage());
        Method.print("Stacktrace:");
        exception.printStackTrace();
    }
}
