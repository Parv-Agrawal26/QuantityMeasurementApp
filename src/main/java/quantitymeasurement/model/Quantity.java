package quantitymeasurement.model;

import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private enum ArithmeticOperation {
        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        DIVIDE((a, b) -> {
            if (b == 0.0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        });

        private final DoubleBinaryOperator compute;

        ArithmeticOperation(DoubleBinaryOperator compute) {
            this.compute = compute;
        }

        public double apply(double a, double b) {
            return compute.applyAsDouble(a, b);
        }
    }

    public Quantity(double value, U unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        this.value = value;
        this.unit = unit;
    }

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(convertedValue, targetUnit);
    }

    private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean targetUnitRequired) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot perform arithmetic with null quantity");
        }

        if (!this.unit.getClass().equals(other.unit.getClass())) {
            throw new IllegalArgumentException("Cannot perform arithmetic on different measurement categories");
        }

        if (!Double.isFinite(this.value) || !Double.isFinite(other.value)) {
            throw new IllegalArgumentException("Values must be finite");
        }

        if (targetUnitRequired && targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
    }

    private double performBaseArithmetic(Quantity<U> other, ArithmeticOperation operation) {
        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);
        return operation.apply(thisBase, otherBase);
    }

    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public Quantity<U> add(Quantity<U> other) {
        validateArithmeticOperands(other, null, false);
        double resultBase = performBaseArithmetic(other, ArithmeticOperation.ADD);
        double resultInThisUnit = unit.convertFromBaseUnit(resultBase);
        return new Quantity<>(roundToTwoDecimals(resultInThisUnit), unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);
        double resultBase = performBaseArithmetic(other, ArithmeticOperation.ADD);
        double resultInTargetUnit = targetUnit.convertFromBaseUnit(resultBase);
        return new Quantity<>(roundToTwoDecimals(resultInTargetUnit), targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        validateArithmeticOperands(other, null, false);
        double resultBase = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
        double resultInThisUnit = unit.convertFromBaseUnit(resultBase);
        return new Quantity<>(roundToTwoDecimals(resultInThisUnit), unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);
        double resultBase = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
        double resultInTargetUnit = targetUnit.convertFromBaseUnit(resultBase);
        return new Quantity<>(roundToTwoDecimals(resultInTargetUnit), targetUnit);
    }

    public double divide(Quantity<U> other) {
        validateArithmeticOperands(other, null, false);
        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Quantity<?> that = (Quantity<?>) obj;

        if (!this.unit.getClass().equals(that.unit.getClass()))
            return false;

        double thisBase = unit.convertToBaseUnit(value);
        double thatBase = that.unit.convertToBaseUnit(that.value);

        return Double.compare(thisBase, thatBase) == 0;
    }

    @Override
    public int hashCode() {

        long bits = Double.doubleToLongBits(unit.convertToBaseUnit(value));
        return (int) (bits ^ (bits >>> 32));
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }
}