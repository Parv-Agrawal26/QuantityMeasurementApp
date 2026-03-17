package com.app.quantitymeasurement.unit;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS,
    FAHRENHEIT,
    KELVIN;

    @Override
    public double getConversionFactor() {
        return 1.0;
    }

    @Override
    public double convertToBaseUnit(double value) {
        switch (this) {
            case CELSIUS:    return value;
            case FAHRENHEIT: return (value - 32.0) * 5.0 / 9.0;
            case KELVIN:     return value - 273.15;
            default:         return value;
        }
    }

    @Override
    public double convertFromBaseUnit(double base) {
        switch (this) {
            case CELSIUS:    return base;
            case FAHRENHEIT: return base * 9.0 / 5.0 + 32.0;
            case KELVIN:     return base + 273.15;
            default:         return base;
        }
    }

    @Override
    public String getUnitName() {
        return name();
    }

    @Override
    public String getMeasurementType() {
        return "TEMPERATURE";
    }

    @Override
    public boolean supportsArithmetic() {
        return false;
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
            "Temperature does not support " + operation + " operation. " +
            "Temperature values cannot be meaningfully added, subtracted, or divided."
        );
    }
}
