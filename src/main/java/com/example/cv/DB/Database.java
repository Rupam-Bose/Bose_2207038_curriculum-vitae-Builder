package com.example.cv.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // TODO: change to your DB config
    private static final String URL = "jdbc:sqlite:cv.db";  // example: SQLite file
    private static final String USER = "";                  // not needed for SQLite
    private static final String PASSWORD = "";              // not needed for SQLite

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}