package quantitymeasurement.units;

public interface IMeasurable {

    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();

    String getMeasurementType();

    // kept for service layer compatibility
    default double toBase(double value) {
        return convertToBaseUnit(value);
    }

    default double fromBase(double baseValue) {
        return convertFromBaseUnit(baseValue);
    }

    default boolean supportsArithmetic() {
        return true;
    }

    default void validateOperationSupport(String operation) {
    }
}
