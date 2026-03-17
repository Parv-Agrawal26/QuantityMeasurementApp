package com.app.quantitymeasurement.repository;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.exception.DatabaseException;
import com.app.quantitymeasurement.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple JDBC-backed repository stub. This is a minimal implementation
 * that demonstrates where database logic would live. It expects a table
 * `measurements(operation, operand1, operand2, result)` to exist.
 */
public class QuantityMeasurementDatabaseRepository implements IQuantityMeasurementRepository {

    private final ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public void save(QuantityMeasurementEntity entity) {
        String sql = "INSERT INTO measurements (operation, operand1, operand2, result) VALUES (?, ?, ?, ?)";
        try (Connection conn = pool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
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
