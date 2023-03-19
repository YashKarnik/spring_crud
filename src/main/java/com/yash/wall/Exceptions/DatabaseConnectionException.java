package com.yash.wall.Exceptions;

import java.sql.SQLException;

public class DatabaseConnectionException extends RuntimeException {
    public DatabaseConnectionException() {
        super(ExceptionMessages.DATABASE_CONNECTION_ERROR);
    }

    public DatabaseConnectionException(SQLException se) {
        super(se.getLocalizedMessage());
    }

    public DatabaseConnectionException(ClassNotFoundException cnfe) {
        super(cnfe.getLocalizedMessage());
    }
}
