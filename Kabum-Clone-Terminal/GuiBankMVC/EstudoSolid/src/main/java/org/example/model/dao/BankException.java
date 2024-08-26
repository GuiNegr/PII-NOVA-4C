package org.example.model.dao;

import java.sql.SQLException;

public class BankException extends SQLException {
    public BankException(String message) {
        super(message);
    }
}
