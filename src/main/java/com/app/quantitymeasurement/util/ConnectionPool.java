package com.app.quantitymeasurement.util;

import com.app.quantitymeasurement.exception.DatabaseException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPool {

    private static ConnectionPool instance;

    private ConnectionPool() {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Run schema.sql once to ensure table exists (for MySQL)
            try (Connection conn = DriverManager.getConnection(DatabaseConfig.getJdbcUrl(), DatabaseConfig.getUsername(), DatabaseConfig.getPassword())) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("db/schema.sql");
                if (is != null) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(is)); Statement stmt = conn.createStatement()) {
                        StringBuilder sql = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            sql.append(line).append('\n');
                        }
                        // Split statements by semicolon and execute each (trimmed)
                        for (String s : sql.toString().split(";")) {
                            String trimmed = s.trim();
                            if (!trimmed.isEmpty()) stmt.execute(trimmed);
                        }
                    }
                }
            } catch (Exception e) {
                throw new DatabaseException("Failed to initialize database schema", e);
            }
        } catch (ClassNotFoundException e) {
            throw new DatabaseException("JDBC Driver not found", e);
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) instance = new ConnectionPool();
        return instance;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(DatabaseConfig.getJdbcUrl(), DatabaseConfig.getUsername(), DatabaseConfig.getPassword());
        } catch (SQLException e) {
            throw new DatabaseException("Unable to get DB connection", e);
        }
    }
}