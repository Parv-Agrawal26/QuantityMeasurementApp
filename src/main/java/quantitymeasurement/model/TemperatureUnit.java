package quantitymeasurement.model;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS(0.0, celsius -> celsius, celsius -> celsius),
    FAHRENHEIT(32.0, fahrenheit -> (fahrenheit - 32.0) * 5.0 / 9.0, celsius -> (celsius * 9.0 / 5.0) + 32.0);

    private final double offset;
    private final Function<Double, Double> toCelsius;
    private final Function<Double, Double> fromCelsius;

    SupportsArithmetic supportsArithmetic = () -> false;

    TemperatureUnit(double offset, Function<Double, Double> toCelsius, Function<Double, Double> fromCelsius) {
        this.offset = offset;
        this.toCelsius = toCelsius;
        this.fromCelsius = fromCelsius;
    }

    @Override
    public double getConversionFactor() {
        return 1.0;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return toCelsius.apply(value);
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return fromCelsius.apply(baseValue);
    }

    @Override
    public String getUnitName() {
        return name();
    }

    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
            "Temperature does not support " + operation + " operation. " +
            "Temperature values cannot be meaningfully added, subtracted, or divided."
        );
    }
}
