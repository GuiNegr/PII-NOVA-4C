package org.example.model.user.dao;

import java.sql.SQLException;

public class DatabaseException extends SQLException {
    public DatabaseException(String message) {
        super(message);
    }
}
