package quantitymeasurement.model;

import quantitymeasurement.units.LengthUnit;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
        return new QuantityLength(targetUnit.convertFromBaseUnit(unit.convertToBaseUnit(value)), targetUnit);
    }

    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (sourceUnit == null || targetUnit == null)
            throw new IllegalArgumentException("Units cannot be null");
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");
        return targetUnit.convertFromBaseUnit(sourceUnit.convertToBaseUnit(value));
    }

    public QuantityLength add(QuantityLength other) {
        if (other == null)
            throw new IllegalArgumentException("Cannot add null quantity");
        double sumBase = unit.convertToBaseUnit(value) + other.unit.convertToBaseUnit(other.value);
        return new QuantityLength(unit.convertFromBaseUnit(sumBase), unit);
    }

    public static QuantityLength add(QuantityLength l1, QuantityLength l2, LengthUnit targetUnit) {
        if (l1 == null || l2 == null)
            throw new IllegalArgumentException("Cannot add null quantities");
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
        double sumBase = l1.unit.convertToBaseUnit(l1.value) + l2.unit.convertToBaseUnit(l2.value);
        return new QuantityLength(targetUnit.convertFromBaseUnit(sumBase), targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityLength that = (QuantityLength) obj;
        return Double.compare(unit.convertToBaseUnit(value), that.unit.convertToBaseUnit(that.value)) == 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit.name().toLowerCase());
    }

    public double getValue() { return value; }
    public LengthUnit getUnit() { return unit; }
}
