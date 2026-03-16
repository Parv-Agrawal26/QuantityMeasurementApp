package quantitymeasurement.model;

import quantitymeasurement.units.WeightUnit;

public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
        return new QuantityWeight(targetUnit.convertFromBaseUnit(unit.convertToBaseUnit(value)), targetUnit);
    }

    public static double convert(double value, WeightUnit sourceUnit, WeightUnit targetUnit) {
        if (sourceUnit == null || targetUnit == null)
            throw new IllegalArgumentException("Units cannot be null");
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");
        return targetUnit.convertFromBaseUnit(sourceUnit.convertToBaseUnit(value));
    }

    public QuantityWeight add(QuantityWeight other) {
        if (other == null)
            throw new IllegalArgumentException("Cannot add null weight");
        double sumBase = unit.convertToBaseUnit(value) + other.unit.convertToBaseUnit(other.value);
        return new QuantityWeight(unit.convertFromBaseUnit(sumBase), unit);
    }

    public static QuantityWeight add(QuantityWeight w1, QuantityWeight w2, WeightUnit targetUnit) {
        if (w1 == null || w2 == null)
            throw new IllegalArgumentException("Cannot add null weights");
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
        double sumBase = w1.unit.convertToBaseUnit(w1.value) + w2.unit.convertToBaseUnit(w2.value);
        return new QuantityWeight(targetUnit.convertFromBaseUnit(sumBase), targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityWeight that = (QuantityWeight) obj;
        return Double.compare(unit.convertToBaseUnit(value), that.unit.convertToBaseUnit(that.value)) == 0;
    }

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(unit.convertToBaseUnit(value));
        return (int) (bits ^ (bits >>> 32));
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit.name().toLowerCase());
    }

    public double getValue() { return value; }
    public WeightUnit getUnit() { return unit; }
}
