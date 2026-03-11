package quantitymeasurement.presentation;

import quantitymeasurement.model.*;

public class QuantityMeasurementApp {

    public static <U extends IMeasurable> void demonstrateEquality(
            Quantity<U> q1,
            Quantity<U> q2) {

        System.out.println(q1 + " equals " + q2 + " : " + q1.equals(q2));
    }

    public static <U extends IMeasurable> void demonstrateConversion(
            Quantity<U> quantity,
            U targetUnit) {

        System.out.println(quantity + " -> " + quantity.convertTo(targetUnit));
    }

    public static <U extends IMeasurable> void demonstrateAddition(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit) {

        System.out.println(q1 + " + " + q2 + " = " + q1.add(q2, targetUnit));
    }

    public static <U extends IMeasurable> void demonstrateSubtraction(
            Quantity<U> q1,
            Quantity<U> q2) {

        System.out.println(q1 + " - " + q2 + " = " + q1.subtract(q2));
    }

    public static <U extends IMeasurable> void demonstrateSubtraction(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit) {

        System.out.println(q1 + " - " + q2 + " = " + q1.subtract(q2, targetUnit));
    }

    public static <U extends IMeasurable> void demonstrateDivision(
            Quantity<U> q1,
            Quantity<U> q2) {

        System.out.println(q1 + " ÷ " + q2 + " = " + q1.divide(q2));
    }

    public static <U extends IMeasurable> void demonstrateUnsupportedOperation(
            String operationName,
            Runnable operation) {

        try {
            operation.run();
        } catch (UnsupportedOperationException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Length Operations ===");

        Quantity<LengthUnit> l1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> l2 =
                new Quantity<>(12.0, LengthUnit.INCH);

        demonstrateEquality(l1, l2);

        demonstrateConversion(l1, LengthUnit.INCH);

        demonstrateAddition(l1, l2, LengthUnit.FEET);

        demonstrateSubtraction(l1, l2);

        demonstrateSubtraction(l1, l2, LengthUnit.INCH);

        demonstrateDivision(l1, l2);


        System.out.println("\n=== Weight Operations ===");

        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        demonstrateEquality(w1, w2);

        demonstrateConversion(w1, WeightUnit.GRAM);

        demonstrateAddition(w1, w2, WeightUnit.KILOGRAM);

        demonstrateSubtraction(w1, w2);

        demonstrateSubtraction(w1, w2, WeightUnit.GRAM);

        demonstrateDivision(w1, w2);


        System.out.println("\n=== Volume Operations ===");

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> v3 =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        demonstrateEquality(v1, v2);

        demonstrateConversion(v1, VolumeUnit.MILLILITRE);

        demonstrateAddition(v1, v2, VolumeUnit.LITRE);

        demonstrateAddition(v1, v3, VolumeUnit.MILLILITRE);

        demonstrateSubtraction(v1, v2);

        demonstrateSubtraction(v1, v3, VolumeUnit.LITRE);

        demonstrateDivision(v1, v2);


        System.out.println("\n=== Temperature Operations ===");

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> t3 =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t4 =
                new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT);

        demonstrateEquality(t1, t2);

        demonstrateEquality(t3, t4);

        demonstrateConversion(t1, TemperatureUnit.FAHRENHEIT);

        demonstrateConversion(t3, TemperatureUnit.FAHRENHEIT);

        demonstrateConversion(t2, TemperatureUnit.CELSIUS);

        System.out.println("\n=== Temperature Unsupported Operations ===");

        demonstrateUnsupportedOperation("Addition", () -> t1.add(t3));

        demonstrateUnsupportedOperation("Subtraction", () -> t1.subtract(t3));

        demonstrateUnsupportedOperation("Division", () -> t1.divide(t3));
    }
}