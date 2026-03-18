package com.app.quantitymeasurement.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.exception.DatabaseException;
import com.app.quantitymeasurement.util.DatabaseConfig;

/**
 * Simple JDBC-backed repository stub. This is a minimal implementation
 * that demonstrates where database logic would live. It expects a table
 * `measurements(operation, operand1, operand2, result)` to exist.
 */
public class QuantityMeasurementDatabaseRepository implements IQuantityMeasurementRepository {

    static {
        initializeSchema();
    }

    private static void initializeSchema() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = createConnection()) {
                InputStream is = QuantityMeasurementDatabaseRepository.class
                        .getClassLoader()
                        .getResourceAsStream("db/schema.sql");
                if (is != null) {
                    executeSqlScript(conn, is);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new DatabaseException("JDBC Driver not found", e);
        } catch (SQLException e) {
            throw new DatabaseException("Failed to initialize database schema", e);
        }
    }

    private static void executeSqlScript(Connection conn, InputStream scriptStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(scriptStream));
             Statement stmt = conn.createStatement()) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line).append('\n');
            }
            for (String statement : sql.toString().split(";")) {
                String trimmed = statement.trim();
                if (!trimmed.isEmpty()) {
                    stmt.execute(trimmed);
                }
            }
        } catch (SQLException | IOException e) {
            throw new DatabaseException("Failed to initialize database schema", e);
        }
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                DatabaseConfig.getJdbcUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword());
    }

    @Override
    public void save(QuantityMeasurementEntity entity) {
        String sql = "INSERT INTO measurements (operation, operand1, operand2, result) VALUES (?, ?, ?, ?)";
        try (Connection conn = createConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getOperation());
            ps.setString(2, entity.getOperand1());
            ps.setString(3, entity.getOperand2());
            ps.setString(4, entity.getResult());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to save measurement", e);
        }
    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {
        // For brevity, return empty list. A real implementation would query the DB.
        return new ArrayList<>();
    }
}
