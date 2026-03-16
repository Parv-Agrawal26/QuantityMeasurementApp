package quantitymeasurement.model;

import org.junit.jupiter.api.Test;

import quantitymeasurement.units.IMeasurable;
import quantitymeasurement.units.LengthUnit;
import quantitymeasurement.units.TemperatureUnit;
import quantitymeasurement.units.VolumeUnit;
import quantitymeasurement.units.WeightUnit;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureTest {

    private static final double EPSILON = 1e-2;

    // Temperature Equality Tests
    @Test
    public void testTemperatureEquality_CelsiusToCelsius_SameValue() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        assertTrue(t1.equals(t2), "0.0°C should equal 0.0°C");
    }

    @Test
    public void testTemperatureEquality_FahrenheitToFahrenheit_SameValue() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        Quantity<TemperatureUnit> t2 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        assertTrue(t1.equals(t2), "32.0°F should equal 32.0°F");
    }

    @Test
    public void testTemperatureEquality_CelsiusToFahrenheit_0Celsius32Fahrenheit() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        assertTrue(t1.equals(t2), "0.0°C should equal 32.0°F");
    }

    @Test
    public void testTemperatureEquality_CelsiusToFahrenheit_100Celsius212Fahrenheit() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT);
        assertTrue(t1.equals(t2), "100.0°C should equal 212.0°F");
    }

    @Test
    public void testTemperatureEquality_CelsiusToFahrenheit_Negative40Equal() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(-40.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(-40.0, TemperatureUnit.FAHRENHEIT);
        assertTrue(t1.equals(t2), "-40.0°C should equal -40.0°F");
    }

    @Test
    public void testTemperatureEquality_SymmetricProperty() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        assertTrue(t1.equals(t2) && t2.equals(t1), "Equality should be symmetric");
    }

    @Test
    public void testTemperatureEquality_ReflexiveProperty() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertTrue(t1.equals(t1), "Temperature should equal itself");
    }

    @Test
    public void testTemperatureEquality_DifferentValues() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertFalse(t1.equals(t2), "50.0°C should not equal 100.0°C");
    }

    @Test
    public void testTemperatureEquality_NullComparison() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertFalse(t1.equals(null), "Temperature should not equal null");
    }

    // Temperature Conversion Tests
    @Test
    public void testTemperatureConversion_CelsiusToFahrenheit_0C() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = t1.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(32.0, result.getValue(), EPSILON, "0.0°C should convert to 32.0°F");
        assertEquals(TemperatureUnit.FAHRENHEIT, result.getUnit());
    }

    @Test
    public void testTemperatureConversion_CelsiusToFahrenheit_100C() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = t1.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(212.0, result.getValue(), EPSILON, "100.0°C should convert to 212.0°F");
        assertEquals(TemperatureUnit.FAHRENHEIT, result.getUnit());
    }

    @Test
    public void testTemperatureConversion_FahrenheitToCelsius_32F() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        Quantity<TemperatureUnit> result = t1.convertTo(TemperatureUnit.CELSIUS);
        assertEquals(0.0, result.getValue(), EPSILON, "32.0°F should convert to 0.0°C");
        assertEquals(TemperatureUnit.CELSIUS, result.getUnit());
    }

    @Test
    public void testTemperatureConversion_FahrenheitToCelsius_212F() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(212.0, TemperatureUnit.FAHRENHEIT);
        Quantity<TemperatureUnit> result = t1.convertTo(TemperatureUnit.CELSIUS);
        assertEquals(100.0, result.getValue(), EPSILON, "212.0°F should convert to 100.0°C");
        assertEquals(TemperatureUnit.CELSIUS, result.getUnit());
    }

    @Test
    public void testTemperatureConversion_Negative40() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(-40.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = t1.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(-40.0, result.getValue(), EPSILON, "-40.0°C should convert to -40.0°F");
    }

    @Test
    public void testTemperatureConversion_SameUnit() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = t1.convertTo(TemperatureUnit.CELSIUS);
        assertEquals(50.0, result.getValue(), EPSILON, "Same unit conversion should return original value");
    }

    @Test
    public void testTemperatureConversion_RoundTrip() {
        double original = 25.0;
        Quantity<TemperatureUnit> t1 = new Quantity<>(original, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> converted = t1.convertTo(TemperatureUnit.FAHRENHEIT);
        Quantity<TemperatureUnit> backConverted = converted.convertTo(TemperatureUnit.CELSIUS);
        assertEquals(original, backConverted.getValue(), EPSILON, "Round-trip conversion should preserve value");
    }

    @Test
    public void testTemperatureConversion_NegativeValues() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(-20.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = t1.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(-4.0, result.getValue(), EPSILON, "-20.0°C should convert to -4.0°F");
    }

    @Test
    public void testTemperatureConversion_VariousValues() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = t1.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(122.0, result.getValue(), EPSILON, "50.0°C should convert to 122.0°F");
    }

    @Test
    public void testTemperatureConversion_NullUnit() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertThrows(IllegalArgumentException.class, () -> {
            t1.convertTo(null);
        }, "Converting to null unit should throw IllegalArgumentException");
    }

    // Unsupported Operations Tests
    @Test
    public void testTemperatureUnsupportedOperation_Add() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        UnsupportedOperationException ex = assertThrows(UnsupportedOperationException.class, () -> {
            t1.add(t2);
        }, "Adding temperatures should throw UnsupportedOperationException");
        assertTrue(ex.getMessage().contains("Temperature does not support ADD"), "Error message should explain why");
    }

    @Test
    public void testTemperatureUnsupportedOperation_AddWithTargetUnit() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        assertThrows(UnsupportedOperationException.class, () -> {
            t1.add(t2, TemperatureUnit.FAHRENHEIT);
        }, "Adding temperatures with target unit should throw UnsupportedOperationException");
    }

    @Test
    public void testTemperatureUnsupportedOperation_Subtract() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        UnsupportedOperationException ex = assertThrows(UnsupportedOperationException.class, () -> {
            t1.subtract(t2);
        }, "Subtracting temperatures should throw UnsupportedOperationException");
        assertTrue(ex.getMessage().contains("Temperature does not support SUBTRACT"), "Error message should explain why");
    }

    @Test
    public void testTemperatureUnsupportedOperation_SubtractWithTargetUnit() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        assertThrows(UnsupportedOperationException.class, () -> {
            t1.subtract(t2, TemperatureUnit.FAHRENHEIT);
        }, "Subtracting temperatures with target unit should throw UnsupportedOperationException");
    }

    @Test
    public void testTemperatureUnsupportedOperation_Divide() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        UnsupportedOperationException ex = assertThrows(UnsupportedOperationException.class, () -> {
            t1.divide(t2);
        }, "Dividing temperatures should throw UnsupportedOperationException");
        assertTrue(ex.getMessage().contains("Temperature does not support DIVIDE"), "Error message should explain why");
    }

    @Test
    public void testTemperatureUnsupportedOperation_ErrorMessage() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        UnsupportedOperationException ex = assertThrows(UnsupportedOperationException.class, () -> {
            t1.add(t2);
        });
        assertTrue(ex.getMessage().contains("meaningfully"), "Error message should be informative");
    }

    // Cross-Category Prevention Tests
    @Test
    public void testTemperatureVsLengthIncompatibility() {
        Quantity<TemperatureUnit> temp = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<LengthUnit> length = new Quantity<>(100.0, LengthUnit.FEET);
        assertFalse(temp.equals(length), "Temperature and length should not be equal");
    }

    @Test
    public void testTemperatureVsWeightIncompatibility() {
        Quantity<TemperatureUnit> temp = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Quantity<WeightUnit> weight = new Quantity<>(50.0, WeightUnit.KILOGRAM);
        assertFalse(temp.equals(weight), "Temperature and weight should not be equal");
    }

    @Test
    public void testTemperatureVsVolumeIncompatibility() {
        Quantity<TemperatureUnit> temp = new Quantity<>(25.0, TemperatureUnit.CELSIUS);
        Quantity<VolumeUnit> volume = new Quantity<>(25.0, VolumeUnit.LITRE);
        assertFalse(temp.equals(volume), "Temperature and volume should not be equal");
    }

    // Operation Support Methods Tests
    @Test
    public void testTemperatureUnit_SupportsArithmetic_ReturnsFalse() {
        assertFalse(TemperatureUnit.CELSIUS.supportsArithmetic(), "Temperature should not support arithmetic");
        assertFalse(TemperatureUnit.FAHRENHEIT.supportsArithmetic(), "Temperature should not support arithmetic");
    }

    @Test
    public void testLengthUnit_SupportsArithmetic_ReturnsTrue() {
        assertTrue(LengthUnit.FEET.supportsArithmetic(), "Length should support arithmetic");
        assertTrue(LengthUnit.INCH.supportsArithmetic(), "Length should support arithmetic");
    }

    @Test
    public void testWeightUnit_SupportsArithmetic_ReturnsTrue() {
        assertTrue(WeightUnit.KILOGRAM.supportsArithmetic(), "Weight should support arithmetic");
        assertTrue(WeightUnit.GRAM.supportsArithmetic(), "Weight should support arithmetic");
    }

    @Test
    public void testVolumeUnit_SupportsArithmetic_ReturnsTrue() {
        assertTrue(VolumeUnit.LITRE.supportsArithmetic(), "Volume should support arithmetic");
        assertTrue(VolumeUnit.MILLILITRE.supportsArithmetic(), "Volume should support arithmetic");
    }

    // Temperature Unit Tests
    @Test
    public void testTemperatureUnit_AllConstants() {
        assertNotNull(TemperatureUnit.CELSIUS, "CELSIUS constant should exist");
        assertNotNull(TemperatureUnit.FAHRENHEIT, "FAHRENHEIT constant should exist");
    }

    @Test
    public void testTemperatureUnit_NameMethod() {
        assertEquals("CELSIUS", TemperatureUnit.CELSIUS.getUnitName(), "CELSIUS name should be correct");
        assertEquals("FAHRENHEIT", TemperatureUnit.FAHRENHEIT.getUnitName(), "FAHRENHEIT name should be correct");
    }

    @Test
    public void testTemperatureUnit_ConversionFactor() {
        assertEquals(1.0, TemperatureUnit.CELSIUS.getConversionFactor(), EPSILON);
        assertEquals(1.0, TemperatureUnit.FAHRENHEIT.getConversionFactor(), EPSILON);
    }

    @Test
    public void testTemperatureNullUnitValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity<>(100.0, (TemperatureUnit) null);
        }, "Constructor with null unit should throw IllegalArgumentException");
    }

    @Test
    public void testTemperatureNullOperandValidation_InComparison() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertFalse(t1.equals(null), "equals(null) should return false");
    }

    @Test
    public void testTemperatureDifferentValuesInequality() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertFalse(t1.equals(t2), "50°C should not equal 100°C");
    }

    // Backward Compatibility Tests
    @Test
    public void testBackwardCompatibility_LengthOperationsStillWork() {
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCH);
        
        assertTrue(l1.equals(l2), "Length equality should still work");
        assertEquals(2.0, l1.add(l2).getValue(), EPSILON, "Length addition should still work");
        assertEquals(0.0, l1.subtract(l2).getValue(), EPSILON, "Length subtraction should still work");
        assertEquals(1.0, l1.divide(l2), EPSILON, "Length division should still work");
    }

    @Test
    public void testBackwardCompatibility_WeightOperationsStillWork() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        
        assertTrue(w1.equals(w2), "Weight equality should still work");
        assertEquals(2.0, w1.add(w2).getValue(), EPSILON, "Weight addition should still work");
        assertEquals(0.0, w1.subtract(w2).getValue(), EPSILON, "Weight subtraction should still work");
        assertEquals(1.0, w1.divide(w2), EPSILON, "Weight division should still work");
    }

    @Test
    public void testBackwardCompatibility_VolumeOperationsStillWork() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        
        assertTrue(v1.equals(v2), "Volume equality should still work");
        assertEquals(2.0, v1.add(v2).getValue(), EPSILON, "Volume addition should still work");
        assertEquals(0.0, v1.subtract(v2).getValue(), EPSILON, "Volume subtraction should still work");
        assertEquals(1.0, v1.divide(v2), EPSILON, "Volume division should still work");
    }

    // Integration Tests
    @Test
    public void testTemperatureIntegrationWithGenericQuantity() {
        Quantity<TemperatureUnit> temp = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        assertNotNull(temp, "Quantity<TemperatureUnit> should work seamlessly");
        assertEquals(100.0, temp.getValue(), EPSILON);
        assertEquals(TemperatureUnit.CELSIUS, temp.getUnit());
    }

    @Test
    public void testTemperatureEnumImplementsIMeasurable() {
        assertTrue(TemperatureUnit.CELSIUS instanceof IMeasurable, "TemperatureUnit should implement IMeasurable");
    }

    @Test
    public void testTemperatureValidateOperationSupport_MethodBehavior() {
        assertThrows(UnsupportedOperationException.class, () -> {
            TemperatureUnit.CELSIUS.validateOperationSupport("addition");
        }, "Direct call to validateOperationSupport should throw exception");
    }

    @Test
    public void testTemperatureConversionPrecision_Epsilon() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(37.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(98.6, TemperatureUnit.FAHRENHEIT);
        assertTrue(t1.equals(t2), "37°C should equal 98.6°F within epsilon");
    }

    @Test
    public void testTemperatureConversionEdgeCase_VerySmallDifference() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(0.01, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> result = t1.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(32.018, result.getValue(), EPSILON, "Small temperature should convert accurately");
    }
}
