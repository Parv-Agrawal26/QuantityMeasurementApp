package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.exception.QuantityMeasurementException;
import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.app.quantitymeasurement.unit.*;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        IMeasurable u1 = parseUnit(q1.getUnit());
        IMeasurable u2 = parseUnit(q2.getUnit());
        validateCategory(u1, u2);
        double base1 = u1.convertToBaseUnit(q1.getValue());
        double base2 = u2.convertToBaseUnit(q2.getValue());
        boolean result = Double.compare(base1, base2) == 0;
        repository.save(new QuantityMeasurementEntity("COMPARE",
                q1.getValue() + " " + q1.getUnit(),
                q2.getValue() + " " + q2.getUnit(),
                String.valueOf(result)));
        return result;
    }

    @Override
    public QuantityDTO convert(QuantityDTO q, String targetUnit) {
        IMeasurable source = parseUnit(q.getUnit());
        IMeasurable target = parseUnit(targetUnit);
        validateCategory(source, target);
        double result = target.convertFromBaseUnit(source.convertToBaseUnit(q.getValue()));
        repository.save(new QuantityMeasurementEntity("CONVERT",
                q.getValue() + " " + q.getUnit(), null,
                result + " " + targetUnit));
        return new QuantityDTO(result, targetUnit, q.getType());
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {
        if ("TEMPERATURE".equals(q1.getType()))
            throw new QuantityMeasurementException("Temperature addition not supported");
        IMeasurable u1 = parseUnit(q1.getUnit());
        IMeasurable u2 = parseUnit(q2.getUnit());
        validateCategory(u1, u2);
        double baseSum = u1.convertToBaseUnit(q1.getValue()) + u2.convertToBaseUnit(q2.getValue());
        double result = u1.convertFromBaseUnit(baseSum);
        repository.save(new QuantityMeasurementEntity("ADD",
                q1.getValue() + " " + q1.getUnit(),
                q2.getValue() + " " + q2.getUnit(),
                result + " " + q1.getUnit()));
        return new QuantityDTO(result, q1.getUnit(), q1.getType());
    }

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {
        if ("TEMPERATURE".equals(q1.getType()))
            throw new QuantityMeasurementException("Temperature subtraction not supported");
        IMeasurable u1 = parseUnit(q1.getUnit());
        IMeasurable u2 = parseUnit(q2.getUnit());
        validateCategory(u1, u2);
        double base = u1.convertToBaseUnit(q1.getValue()) - u2.convertToBaseUnit(q2.getValue());
        double result = u1.convertFromBaseUnit(base);
        repository.save(new QuantityMeasurementEntity("SUBTRACT",
                q1.getValue() + " " + q1.getUnit(),
                q2.getValue() + " " + q2.getUnit(),
                result + " " + q1.getUnit()));
        return new QuantityDTO(result, q1.getUnit(), q1.getType());
    }

    @Override
    public double divide(QuantityDTO q1, QuantityDTO q2) {
        IMeasurable u1 = parseUnit(q1.getUnit());
        IMeasurable u2 = parseUnit(q2.getUnit());
        validateCategory(u1, u2);
        double base1 = u1.convertToBaseUnit(q1.getValue());
        double base2 = u2.convertToBaseUnit(q2.getValue());
        if (base2 == 0)
            throw new QuantityMeasurementException("Division by zero");
        double result = base1 / base2;
        repository.save(new QuantityMeasurementEntity("DIVIDE",
                q1.getValue() + " " + q1.getUnit(),
                q2.getValue() + " " + q2.getUnit(),
                String.valueOf(result)));
        return result;
    }

    private void validateCategory(IMeasurable u1, IMeasurable u2) {
        if (!u1.getMeasurementType().equals(u2.getMeasurementType()))
            throw new QuantityMeasurementException("Cannot operate on different measurement types");
    }

    private IMeasurable parseUnit(String unit) {
        try { return LengthUnit.valueOf(unit); } catch (Exception ignored) {}
        try { return WeightUnit.valueOf(unit); } catch (Exception ignored) {}
        try { return VolumeUnit.valueOf(unit); } catch (Exception ignored) {}
        try { return TemperatureUnit.valueOf(unit); } catch (Exception ignored) {}
        throw new QuantityMeasurementException("Invalid unit: " + unit);
    }
}
