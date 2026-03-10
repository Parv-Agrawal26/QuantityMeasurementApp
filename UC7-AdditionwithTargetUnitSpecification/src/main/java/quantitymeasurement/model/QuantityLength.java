package quantitymeasurement.model;

public class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        this.value = value;
        this.unit = unit;
    }


    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new QuantityLength(convertedValue, targetUnit);
    }


    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (sourceUnit == null || targetUnit == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        
        double valueInFeet = value * sourceUnit.getConversionFactor();
        return valueInFeet / targetUnit.getConversionFactor();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityLength that = (QuantityLength) obj;
        return Double.compare(this.getValueInFeet(), that.getValueInFeet()) == 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit.name().toLowerCase());
    }

    private double getValueInFeet() {
        return value * unit.getConversionFactor();
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }


    public QuantityLength add(QuantityLength other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot add null quantity");
        }
        double thisInFeet = this.getValueInFeet();
        double otherInFeet = other.getValueInFeet();
        double sumInFeet = thisInFeet + otherInFeet;
        double sumInThisUnit = sumInFeet / this.unit.getConversionFactor();
        return new QuantityLength(sumInThisUnit, this.unit);
    }

    public static QuantityLength add(QuantityLength length1, QuantityLength length2, LengthUnit targetUnit) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Cannot add null quantities");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double value1InFeet = length1.getValueInFeet();
        double value2InFeet = length2.getValueInFeet();
        double sumInFeet = value1InFeet + value2InFeet;
        double sumInTargetUnit = sumInFeet / targetUnit.getConversionFactor();
        return new QuantityLength(sumInTargetUnit, targetUnit);
    }
}