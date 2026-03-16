package quantitymeasurement.model;

import java.util.function.DoubleBinaryOperator;
import quantitymeasurement.units.IMeasurable;
import quantitymeasurement.units.TemperatureUnit;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private enum ArithmeticOperation {
        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        DIVIDE((a, b) -> {
            if (b == 0.0)
                throw new ArithmeticException("Cannot divide by zero");
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
        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);
        return new Quantity<>(converted, targetUnit);
    }

    private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean targetUnitRequired) {
        if (other == null)
            throw new IllegalArgumentException("Cannot perform arithmetic with null quantity");
        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cannot perform arithmetic on different measurement categories");
        if (!Double.isFinite(this.value) || !Double.isFinite(other.value))
            throw new IllegalArgumentException("Values must be finite");
        if (targetUnitRequired && targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
    }

    private double performBaseArithmetic(Quantity<U> other, ArithmeticOperation operation) {
        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);
        return operation.apply(thisBase, otherBase);
    }

    private double roundToTwoDecimals(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    public Quantity<U> add(Quantity<U> other) {
        unit.validateOperationSupport("ADD");
        validateArithmeticOperands(other, null, false);
        double resultBase = performBaseArithmetic(other, ArithmeticOperation.ADD);
        return new Quantity<>(roundToTwoDecimals(unit.convertFromBaseUnit(resultBase)), unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        unit.validateOperationSupport("ADD");
        validateArithmeticOperands(other, targetUnit, true);
        double resultBase = performBaseArithmetic(other, ArithmeticOperation.ADD);
        return new Quantity<>(roundToTwoDecimals(targetUnit.convertFromBaseUnit(resultBase)), targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        unit.validateOperationSupport("SUBTRACT");
        validateArithmeticOperands(other, null, false);
        double resultBase = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
        return new Quantity<>(roundToTwoDecimals(unit.convertFromBaseUnit(resultBase)), unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        unit.validateOperationSupport("SUBTRACT");
        validateArithmeticOperands(other, targetUnit, true);
        double resultBase = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
        return new Quantity<>(roundToTwoDecimals(targetUnit.convertFromBaseUnit(resultBase)), targetUnit);
    }

    public double divide(Quantity<U> other) {
        unit.validateOperationSupport("DIVIDE");
        validateArithmeticOperands(other, null, false);
        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Quantity<?> that = (Quantity<?>) obj;
        if (!this.unit.getClass().equals(that.unit.getClass())) return false;
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
