package quantitymeasurement.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_SameValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        assertTrue(feet1.equals(feet2), "1.0 ft should equal 1.0 ft");
    }

    @Test
    public void testEquality_DifferentValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);
        assertFalse(feet1.equals(feet2), "1.0 ft should not equal 2.0 ft");
    }

    @Test
    public void testEquality_NullComparison() {
        Feet feet1 = new Feet(1.0);
        assertFalse(feet1.equals(null), "Feet should not equal null");
    }

    @Test
    public void testEquality_NonNumericInput() {
        Feet feet1 = new Feet(1.0);
        String nonNumeric = "1.0";
        assertFalse(feet1.equals(nonNumeric), "Feet should not equal non-Feet object");
    }

    @Test
    public void testEquality_SameReference() {
        Feet feet1 = new Feet(1.0);
        assertTrue(feet1.equals(feet1), "Feet should equal itself (reflexive)");
    }

    @Test
    public void testInchesEquality_SameValue() {
        Inches inches1 = new Inches(1.0);
        Inches inches2 = new Inches(1.0);
        assertTrue(inches1.equals(inches2), "1.0 inch should equal 1.0 inch");
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Inches inches1 = new Inches(1.0);
        Inches inches2 = new Inches(2.0);
        assertFalse(inches1.equals(inches2), "1.0 inch should not equal 2.0 inch");
    }
 
    @Test
    public void testInchesEquality_NullComparison() {
        Inches inches1 = new Inches(1.0);
        assertFalse(inches1.equals(null), "Inches should not equal null");
    }

    @Test
    public void testInchesEquality_NonNumericInput() {
        Inches inches1 = new Inches(1.0);
        String nonNumeric = "1.0";
        assertFalse(inches1.equals(nonNumeric), "Inches should not equal non-Inches object");
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches inches1 = new Inches(1.0);
        assertTrue(inches1.equals(inches1), "Inches should equal itself (reflexive)");
    }

    // UC3: Generic Quantity Class Tests
    @Test
    public void testEquality_FeetToFeet_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2), "1.0 feet should equal 1.0 feet");
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2), "1.0 inch should equal 1.0 inch");
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2), "1.0 feet should equal 12.0 inches");
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2), "12.0 inches should equal 1.0 feet");
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2), "1.0 feet should not equal 2.0 feet");
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.INCH);
        assertFalse(q1.equals(q2), "1.0 inch should not equal 2.0 inch");
    }

    @Test
    public void testEquality_QuantityLength_SameReference() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q1), "QuantityLength should equal itself (reflexive)");
    }

    @Test
    public void testEquality_QuantityLength_NullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q1.equals(null), "QuantityLength should not equal null");
    }

    // UC4: Extended Unit Support Tests
    @Test
    public void testEquality_YardToYard_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q2), "1.0 yard should equal 1.0 yard");
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.YARDS);
        assertFalse(q1.equals(q2), "1.0 yard should not equal 2.0 yards");
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2), "1.0 yard should equal 3.0 feet");
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q2), "3.0 feet should equal 1.0 yard");
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(36.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2), "1.0 yard should equal 36.0 inches");
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(36.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q2), "36.0 inches should equal 1.0 yard");
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2), "1.0 yard should not equal 2.0 feet");
    }

    @Test
    public void testEquality_CentimetersToCentimeters_SameValue() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.CENTIMETERS);
        assertTrue(q1.equals(q2), "2.0 cm should equal 2.0 cm");
    }

    @Test
    public void testEquality_CentimetersToInches_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(0.393701, LengthUnit.INCH);
        assertTrue(q1.equals(q2), "1.0 cm should equal 0.393701 inches");
    }

    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2), "1.0 cm should not equal 1.0 feet");
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength q3 = new QuantityLength(36.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2) && q2.equals(q3) && q1.equals(q3), "Transitive property should hold");
    }

    @Test
    public void testEquality_YardSameReference() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q1), "Yard should equal itself (reflexive)");
    }

    @Test
    public void testEquality_YardNullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertFalse(q1.equals(null), "Yard should not equal null");
    }

    @Test
    public void testEquality_CentimetersSameReference() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        assertTrue(q1.equals(q1), "Centimeters should equal itself (reflexive)");
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        assertFalse(q1.equals(null), "Centimeters should not equal null");
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(6.0, LengthUnit.FEET);
        QuantityLength q3 = new QuantityLength(72.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2) && q2.equals(q3) && q1.equals(q3), "Complex multi-unit scenario should work");
    }

    // UC5: Unit-to-Unit Conversion Tests
    @Test
    public void testConversion_FeetToInches() {
        double result = QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH);
        assertEquals(12.0, result, 1e-6, "1.0 feet should convert to 12.0 inches");
    }

    @Test
    public void testConversion_InchesToFeet() {
        double result = QuantityLength.convert(24.0, LengthUnit.INCH, LengthUnit.FEET);
        assertEquals(2.0, result, 1e-6, "24.0 inches should convert to 2.0 feet");
    }

    @Test
    public void testConversion_YardsToInches() {
        double result = QuantityLength.convert(1.0, LengthUnit.YARDS, LengthUnit.INCH);
        assertEquals(36.0, result, 1e-6, "1.0 yard should convert to 36.0 inches");
    }

    @Test
    public void testConversion_InchesToYards() {
        double result = QuantityLength.convert(72.0, LengthUnit.INCH, LengthUnit.YARDS);
        assertEquals(2.0, result, 1e-6, "72.0 inches should convert to 2.0 yards");
    }

    @Test
    public void testConversion_CentimetersToInches() {
        double result = QuantityLength.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCH);
        assertEquals(1.0, result, 1e-3, "2.54 cm should convert to ~1.0 inches");
    }

    @Test
    public void testConversion_FeetToYards() {
        double result = QuantityLength.convert(6.0, LengthUnit.FEET, LengthUnit.YARDS);
        assertEquals(2.0, result, 1e-6, "6.0 feet should convert to 2.0 yards");
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double original = 5.0;
        double converted = QuantityLength.convert(original, LengthUnit.FEET, LengthUnit.INCH);
        double backConverted = QuantityLength.convert(converted, LengthUnit.INCH, LengthUnit.FEET);
        assertEquals(original, backConverted, 1e-6, "Round-trip conversion should preserve original value");
    }

    @Test
    public void testConversion_ZeroValue() {
        double result = QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCH);
        assertEquals(0.0, result, 1e-6, "Zero should convert to zero");
    }

    @Test
    public void testConversion_NegativeValue() {
        double result = QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH);
        assertEquals(-12.0, result, 1e-6, "Negative values should convert correctly");
    }

    @Test
    public void testConversion_SameUnit() {
        double result = QuantityLength.convert(5.0, LengthUnit.FEET, LengthUnit.FEET);
        assertEquals(5.0, result, 1e-6, "Same unit conversion should return original value");
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(1.0, null, LengthUnit.FEET);
        }, "Null source unit should throw IllegalArgumentException");
        
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(1.0, LengthUnit.FEET, null);
        }, "Null target unit should throw IllegalArgumentException");
    }

    @Test
    public void testConversion_NaNValue_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCH);
        }, "NaN value should throw IllegalArgumentException");
    }

    @Test
    public void testConversion_InfiniteValue_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCH);
        }, "Infinite value should throw IllegalArgumentException");
    }

    @Test
    public void testConvertTo_InstanceMethod() {
        QuantityLength original = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength converted = original.convertTo(LengthUnit.INCH);
        assertEquals(12.0, converted.getValue(), 1e-6, "Instance convertTo should work correctly");
        assertEquals(LengthUnit.INCH, converted.getUnit(), "Converted unit should be correct");
    }

    @Test
    public void testConvertTo_NullUnit_Throws() {
        QuantityLength quantity = new QuantityLength(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            quantity.convertTo(null);
        }, "convertTo with null unit should throw IllegalArgumentException");
    }

    @Test
    public void testQuantityLength_Constructor_InvalidInputs() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1.0, null);
        }, "Constructor with null unit should throw IllegalArgumentException");
        
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(Double.NaN, LengthUnit.FEET);
        }, "Constructor with NaN value should throw IllegalArgumentException");
    }

    @Test
    public void testToString_Method() {
        QuantityLength quantity = new QuantityLength(1.5, LengthUnit.FEET);
        String result = quantity.toString();
        assertEquals("1.50 feet", result, "toString should format correctly");
    }

    // UC6: Addition of Two Length Units Tests
    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(3.0, result.getValue(), 1e-6, "1 ft + 2 ft should equal 3 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch() {
        QuantityLength q1 = new QuantityLength(6.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(6.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2);
        assertEquals(12.0, result.getValue(), 1e-6, "6 in + 6 in should equal 12 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result unit should be INCH");
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2);
        assertEquals(2.0, result.getValue(), 1e-6, "1 ft + 12 in should equal 2 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(24.0, result.getValue(), 1e-6, "12 in + 1 ft should equal 24 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result unit should be INCH");
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(2.0, result.getValue(), 1e-6, "1 yd + 3 ft should equal 2 yd");
        assertEquals(LengthUnit.YARDS, result.getUnit(), "Result unit should be YARDS");
    }

    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {
        QuantityLength q1 = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2);
        assertEquals(5.08, result.getValue(), 1e-2, "2.54 cm + 1 in should equal ~5.08 cm");
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit(), "Result unit should be CENTIMETERS");
    }

    @Test
    public void testAddition_Commutativity() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result1 = QuantityLength.add(q1, q2, LengthUnit.FEET);
        QuantityLength result2 = QuantityLength.add(q2, q1, LengthUnit.FEET);
        assertEquals(result1.getValue(), result2.getValue(), 1e-6, "Addition should be commutative");
    }

    @Test
    public void testAddition_WithZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2);
        assertEquals(5.0, result.getValue(), 1e-6, "5 ft + 0 in should equal 5 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_NegativeValues() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(3.0, result.getValue(), 1e-6, "5 ft + (-2 ft) should equal 3 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_NullSecondOperand() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            q1.add(null);
        }, "Adding null should throw IllegalArgumentException");
    }

    @Test
    public void testAddition_StaticMethod_NullOperands() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.add(null, q1, LengthUnit.FEET);
        }, "Null first operand should throw IllegalArgumentException");
    }

    @Test
    public void testAddition_LargeValues() {
        QuantityLength q1 = new QuantityLength(1e6, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1e6, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(2e6, result.getValue(), 1e-6, "Large values should add correctly");
    }

    @Test
    public void testAddition_SmallValues() {
        QuantityLength q1 = new QuantityLength(0.001, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.002, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(0.003, result.getValue(), 1e-6, "Small values should add correctly");
    }

    @Test
    public void testAddition_StaticMethod_WithTargetUnit() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(36.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.FEET);
        assertEquals(6.0, result.getValue(), 1e-6, "1 yd + 36 in should equal 6 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_Immutability() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(1.0, q1.getValue(), 1e-6, "Original q1 should remain unchanged");
        assertEquals(2.0, q2.getValue(), 1e-6, "Original q2 should remain unchanged");
    }

    // UC7: Addition with Target Unit Specification Tests
    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.FEET);
        assertEquals(2.0, result.getValue(), 1e-6, "1 ft + 12 in should equal 2 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.INCH);
        assertEquals(24.0, result.getValue(), 1e-6, "1 ft + 12 in should equal 24 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result unit should be INCH");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        assertEquals(0.667, result.getValue(), 1e-3, "1 ft + 12 in should equal ~0.667 yd");
        assertEquals(LengthUnit.YARDS, result.getUnit(), "Result unit should be YARDS");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.CENTIMETERS);
        assertEquals(5.08, result.getValue(), 1e-2, "1 in + 1 in should equal ~5.08 cm");
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit(), "Result unit should be CENTIMETERS");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        assertEquals(3.0, result.getValue(), 1e-6, "2 yd + 3 ft should equal 3 yd");
        assertEquals(LengthUnit.YARDS, result.getUnit(), "Result unit should be YARDS");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.FEET);
        assertEquals(9.0, result.getValue(), 1e-6, "2 yd + 3 ft should equal 9 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result1 = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        QuantityLength result2 = QuantityLength.add(q2, q1, LengthUnit.YARDS);
        assertEquals(result1.getValue(), result2.getValue(), 1e-6, "Addition should be commutative with explicit target unit");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        assertEquals(1.667, result.getValue(), 1e-3, "5 ft + 0 in should equal ~1.667 yd");
        assertEquals(LengthUnit.YARDS, result.getUnit(), "Result unit should be YARDS");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.INCH);
        assertEquals(36.0, result.getValue(), 1e-6, "5 ft + (-2 ft) should equal 36 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result unit should be INCH");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.add(q1, q2, null);
        }, "Null target unit should throw IllegalArgumentException");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
        QuantityLength q1 = new QuantityLength(1000.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(500.0, LengthUnit.FEET);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.INCH);
        assertEquals(18000.0, result.getValue(), 1e-6, "1000 ft + 500 ft should equal 18000 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result unit should be INCH");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        assertEquals(0.667, result.getValue(), 1e-3, "12 in + 12 in should equal ~0.667 yd");
        assertEquals(LengthUnit.YARDS, result.getUnit(), "Result unit should be YARDS");
    }

    // UC8: Refactoring Unit Enum to Standalone with Conversion Responsibility Tests
    @Test
    public void testLengthUnitEnum_FeetConstant() {
        assertEquals(1.0, LengthUnit.FEET.getConversionFactor(), 1e-6, "FEET conversion factor should be 1.0");
    }

    @Test
    public void testLengthUnitEnum_InchesConstant() {
        assertEquals(0.0833, LengthUnit.INCH.getConversionFactor(), 1e-3, "INCH conversion factor should be ~0.0833");
    }

    @Test
    public void testLengthUnitEnum_YardsConstant() {
        assertEquals(3.0, LengthUnit.YARDS.getConversionFactor(), 1e-6, "YARDS conversion factor should be 3.0");
    }

    @Test
    public void testLengthUnitEnum_CentimetersConstant() {
        assertEquals(0.0328, LengthUnit.CENTIMETERS.getConversionFactor(), 1e-3, "CENTIMETERS conversion factor should be ~0.0328");
    }

    @Test
    public void testConvertToBaseUnit_FeetToFeet() {
        double result = LengthUnit.FEET.convertToBaseUnit(5.0);
        assertEquals(5.0, result, 1e-6, "5 feet to base unit should be 5.0");
    }

    @Test
    public void testConvertToBaseUnit_InchesToFeet() {
        double result = LengthUnit.INCH.convertToBaseUnit(12.0);
        assertEquals(1.0, result, 1e-6, "12 inches to base unit should be 1.0 feet");
    }

    @Test
    public void testConvertToBaseUnit_YardsToFeet() {
        double result = LengthUnit.YARDS.convertToBaseUnit(1.0);
        assertEquals(3.0, result, 1e-6, "1 yard to base unit should be 3.0 feet");
    }

    @Test
    public void testConvertToBaseUnit_CentimetersToFeet() {
        double result = LengthUnit.CENTIMETERS.convertToBaseUnit(30.48);
        assertEquals(1.0, result, 1e-2, "30.48 cm to base unit should be ~1.0 feet");
    }

    @Test
    public void testConvertFromBaseUnit_FeetToFeet() {
        double result = LengthUnit.FEET.convertFromBaseUnit(2.0);
        assertEquals(2.0, result, 1e-6, "2.0 feet from base unit should be 2.0 feet");
    }

    @Test
    public void testConvertFromBaseUnit_FeetToInches() {
        double result = LengthUnit.INCH.convertFromBaseUnit(1.0);
        assertEquals(12.0, result, 1e-6, "1.0 feet from base unit should be 12.0 inches");
    }

    @Test
    public void testConvertFromBaseUnit_FeetToYards() {
        double result = LengthUnit.YARDS.convertFromBaseUnit(3.0);
        assertEquals(1.0, result, 1e-6, "3.0 feet from base unit should be 1.0 yard");
    }

    @Test
    public void testConvertFromBaseUnit_FeetToCentimeters() {
        double result = LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0);
        assertEquals(30.48, result, 1e-2, "1.0 feet from base unit should be ~30.48 cm");
    }

    @Test
    public void testQuantityLengthRefactored_Equality() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2), "Refactored equality should work: 1 ft = 12 in");
    }

    @Test
    public void testQuantityLengthRefactored_ConvertTo() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q1.convertTo(LengthUnit.INCH);
        assertEquals(12.0, result.getValue(), 1e-6, "Refactored convertTo should work: 1 ft = 12 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result unit should be INCH");
    }

    @Test
    public void testQuantityLengthRefactored_Add() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2);
        assertEquals(2.0, result.getValue(), 1e-6, "Refactored add should work: 1 ft + 12 in = 2 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testQuantityLengthRefactored_AddWithTargetUnit() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        assertEquals(0.667, result.getValue(), 1e-3, "Refactored add with target unit: 1 ft + 12 in = ~0.667 yd");
        assertEquals(LengthUnit.YARDS, result.getUnit(), "Result unit should be YARDS");
    }

    @Test
    public void testRoundTripConversion_RefactoredDesign() {
        double original = 5.0;
        double toInches = QuantityLength.convert(original, LengthUnit.FEET, LengthUnit.INCH);
        double backToFeet = QuantityLength.convert(toInches, LengthUnit.INCH, LengthUnit.FEET);
        assertEquals(original, backToFeet, 1e-6, "Round-trip conversion should preserve value in refactored design");
    }

    // UC9: Weight Measurement Tests
    @Test
    public void testEquality_KilogramToKilogram_SameValue() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(w1.equals(w2), "1.0 kg should equal 1.0 kg");
    }

    @Test
    public void testEquality_KilogramToKilogram_DifferentValue() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(2.0, WeightUnit.KILOGRAM);
        assertFalse(w1.equals(w2), "1.0 kg should not equal 2.0 kg");
    }

    @Test
    public void testEquality_KilogramToGram_EquivalentValue() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertTrue(w1.equals(w2), "1.0 kg should equal 1000.0 grams");
    }

    @Test
    public void testEquality_GramToKilogram_EquivalentValue() {
        QuantityWeight w1 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(w1.equals(w2), "1000.0 grams should equal 1.0 kg");
    }

    @Test
    public void testEquality_WeightVsLength_Incompatible() {
        QuantityWeight weight = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityLength length = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(weight.equals(length), "Weight and length should not be equal");
    }

    @Test
    public void testEquality_Weight_NullComparison() {
        QuantityWeight weight = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertFalse(weight.equals(null), "Weight should not equal null");
    }

    @Test
    public void testEquality_Weight_SameReference() {
        QuantityWeight weight = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(weight.equals(weight), "Weight should equal itself");
    }

    @Test
    public void testEquality_Weight_TransitiveProperty() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight w3 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(w1.equals(w2) && w2.equals(w3) && w1.equals(w3), "Transitive property should hold");
    }

    @Test
    public void testEquality_Weight_ZeroValue() {
        QuantityWeight w1 = new QuantityWeight(0.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(0.0, WeightUnit.GRAM);
        assertTrue(w1.equals(w2), "Zero values should be equal across units");
    }

    @Test
    public void testEquality_Weight_NegativeValue() {
        QuantityWeight w1 = new QuantityWeight(-1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(-1000.0, WeightUnit.GRAM);
        assertTrue(w1.equals(w2), "Negative values should convert correctly");
    }

    @Test
    public void testEquality_Weight_LargeValue() {
        QuantityWeight w1 = new QuantityWeight(1000000.0, WeightUnit.GRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.KILOGRAM);
        assertTrue(w1.equals(w2), "Large values should maintain precision");
    }

    @Test
    public void testEquality_Weight_SmallValue() {
        QuantityWeight w1 = new QuantityWeight(0.001, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.GRAM);
        assertTrue(w1.equals(w2), "Small values should maintain precision");
    }

    @Test
    public void testConversion_Weight_PoundToKilogram() {
        double result = QuantityWeight.convert(2.20462, WeightUnit.POUND, WeightUnit.KILOGRAM);
        assertEquals(1.0, result, 1e-3, "2.20462 pounds should convert to ~1.0 kg");
    }

    @Test
    public void testConversion_Weight_KilogramToPound() {
        double result = QuantityWeight.convert(1.0, WeightUnit.KILOGRAM, WeightUnit.POUND);
        assertEquals(2.20462, result, 1e-3, "1.0 kg should convert to ~2.20462 pounds");
    }

    @Test
    public void testConversion_Weight_SameUnit() {
        double result = QuantityWeight.convert(5.0, WeightUnit.KILOGRAM, WeightUnit.KILOGRAM);
        assertEquals(5.0, result, 1e-6, "Same unit conversion should return original value");
    }

    @Test
    public void testConversion_Weight_ZeroValue() {
        double result = QuantityWeight.convert(0.0, WeightUnit.KILOGRAM, WeightUnit.GRAM);
        assertEquals(0.0, result, 1e-6, "Zero should convert to zero");
    }

    @Test
    public void testConversion_Weight_NegativeValue() {
        double result = QuantityWeight.convert(-1.0, WeightUnit.KILOGRAM, WeightUnit.GRAM);
        assertEquals(-1000.0, result, 1e-6, "Negative values should convert correctly");
    }

    @Test
    public void testConversion_Weight_RoundTrip() {
        double original = 1.5;
        double converted = QuantityWeight.convert(original, WeightUnit.KILOGRAM, WeightUnit.GRAM);
        double backConverted = QuantityWeight.convert(converted, WeightUnit.GRAM, WeightUnit.KILOGRAM);
        assertEquals(original, backConverted, 1e-6, "Round-trip conversion should preserve value");
    }

    @Test
    public void testAddition_Weight_SameUnit_KilogramPlusKilogram() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(2.0, WeightUnit.KILOGRAM);
        QuantityWeight result = w1.add(w2);
        assertEquals(3.0, result.getValue(), 1e-6, "1.0 kg + 2.0 kg should equal 3.0 kg");
        assertEquals(WeightUnit.KILOGRAM, result.getUnit(), "Result should be in kilogram");
    }

    @Test
    public void testAddition_Weight_CrossUnit_KilogramPlusGram() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result = w1.add(w2);
        assertEquals(2.0, result.getValue(), 1e-6, "1.0 kg + 1000.0 g should equal 2.0 kg");
        assertEquals(WeightUnit.KILOGRAM, result.getUnit(), "Result should be in first operand's unit");
    }

    @Test
    public void testAddition_Weight_CrossUnit_PoundPlusKilogram() {
        QuantityWeight w1 = new QuantityWeight(2.20462, WeightUnit.POUND);
        QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight result = w1.add(w2);
        assertEquals(4.40924, result.getValue(), 1e-3, "2.20462 lb + 1.0 kg should equal ~4.40924 lb");
    }

    @Test
    public void testAddition_Weight_ExplicitTargetUnit_Gram() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result = QuantityWeight.add(w1, w2, WeightUnit.GRAM);
        assertEquals(2000.0, result.getValue(), 1e-6, "1.0 kg + 1000.0 g should equal 2000.0 g");
        assertEquals(WeightUnit.GRAM, result.getUnit(), "Result should be in gram");
    }

    @Test
    public void testAddition_Weight_WithZero() {
        QuantityWeight w1 = new QuantityWeight(5.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(0.0, WeightUnit.GRAM);
        QuantityWeight result = w1.add(w2);
        assertEquals(5.0, result.getValue(), 1e-6, "Adding zero should return original value");
    }

    @Test
    public void testAddition_Weight_NegativeValues() {
        QuantityWeight w1 = new QuantityWeight(5.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(-2000.0, WeightUnit.GRAM);
        QuantityWeight result = w1.add(w2);
        assertEquals(3.0, result.getValue(), 1e-6, "5.0 kg + (-2000.0 g) should equal 3.0 kg");
    }

    @Test
    public void testAddition_Weight_LargeValues() {
        QuantityWeight w1 = new QuantityWeight(1e6, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1e6, WeightUnit.KILOGRAM);
        QuantityWeight result = w1.add(w2);
        assertEquals(2e6, result.getValue(), 1e-6, "Large value addition should work correctly");
    }

    @Test
    public void testQuantityWeight_Constructor_InvalidInputs() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityWeight(1.0, null);
        }, "Constructor with null unit should throw exception");
        
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityWeight(Double.NaN, WeightUnit.KILOGRAM);
        }, "Constructor with NaN should throw exception");
    }

    @Test
    public void testWeightUnit_ConversionMethods() {
        assertEquals(1.0, WeightUnit.KILOGRAM.convertToBaseUnit(1.0), 1e-6);
        assertEquals(0.001, WeightUnit.GRAM.convertToBaseUnit(1.0), 1e-6);
        assertEquals(0.453592, WeightUnit.POUND.convertToBaseUnit(1.0), 1e-6);
        
        assertEquals(1.0, WeightUnit.KILOGRAM.convertFromBaseUnit(1.0), 1e-6);
        assertEquals(1000.0, WeightUnit.GRAM.convertFromBaseUnit(1.0), 1e-6);
        assertEquals(2.20462, WeightUnit.POUND.convertFromBaseUnit(1.0), 1e-3);
    }

    // UC11: Volume Measurement Tests
    @Test
    public void testEquality_LitreToLitre_SameValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertTrue(v1.equals(v2), "1.0 L should equal 1.0 L");
    }

    @Test
    public void testEquality_LitreToLitre_DifferentValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        assertFalse(v1.equals(v2), "1.0 L should not equal 2.0 L");
    }

    @Test
    public void testEquality_LitreToMillilitre_EquivalentValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        assertTrue(v1.equals(v2), "1.0 L should equal 1000.0 mL");
    }

    @Test
    public void testEquality_MillilitreToLitre_EquivalentValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertTrue(v1.equals(v2), "1000.0 mL should equal 1.0 L");
    }

    @Test
    public void testEquality_LitreToGallon_EquivalentValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.GALLON);
        assertTrue(v1.equals(v2), "3.78541 L should equal 1.0 gallon");
    }

    @Test
    public void testEquality_GallonToLitre_EquivalentValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> v2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        assertTrue(v1.equals(v2), "1.0 gallon should equal 3.78541 L");
    }

    @Test
    public void testEquality_VolumeVsLength_Incompatible() {
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        assertFalse(volume.equals(length), "Volume and length should not be equal");
    }

    @Test
    public void testEquality_VolumeVsWeight_Incompatible() {
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertFalse(volume.equals(weight), "Volume and weight should not be equal");
    }

    @Test
    public void testEquality_Volume_NullComparison() {
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertFalse(volume.equals(null), "Volume should not equal null");
    }

    @Test
    public void testEquality_Volume_SameReference() {
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertTrue(volume.equals(volume), "Volume should equal itself");
    }

    @Test
    public void testEquality_Volume_ZeroValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(0.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
        assertTrue(v1.equals(v2), "Zero values should be equal across units");
    }

    @Test
    public void testConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(1000.0, result.getValue(), 1e-6, "1.0 L should convert to 1000.0 mL");
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit(), "Result unit should be MILLILITRE");
    }

    @Test
    public void testConversion_MillilitreToLitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = v1.convertTo(VolumeUnit.LITRE);
        assertEquals(1.0, result.getValue(), 1e-6, "1000.0 mL should convert to 1.0 L");
        assertEquals(VolumeUnit.LITRE, result.getUnit(), "Result unit should be LITRE");
    }

    @Test
    public void testConversion_GallonToLitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> result = v1.convertTo(VolumeUnit.LITRE);
        assertEquals(3.78541, result.getValue(), 1e-5, "1.0 gallon should convert to 3.78541 L");
        assertEquals(VolumeUnit.LITRE, result.getUnit(), "Result unit should be LITRE");
    }

    @Test
    public void testConversion_LitreToGallon() {
        Quantity<VolumeUnit> v1 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.convertTo(VolumeUnit.GALLON);
        assertEquals(1.0, result.getValue(), 1e-5, "3.78541 L should convert to 1.0 gallon");
        assertEquals(VolumeUnit.GALLON, result.getUnit(), "Result unit should be GALLON");
    }

    @Test
    public void testConversion_Volume_SameUnit() {
        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.convertTo(VolumeUnit.LITRE);
        assertEquals(5.0, result.getValue(), 1e-6, "Same unit conversion should return original value");
    }

    @Test
    public void testAddition_Volume_SameUnit_LitrePlusLitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(3.0, result.getValue(), 1e-6, "1.0 L + 2.0 L should equal 3.0 L");
        assertEquals(VolumeUnit.LITRE, result.getUnit(), "Result should be in litre");
    }

    @Test
    public void testAddition_Volume_CrossUnit_LitrePlusMillilitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(2.0, result.getValue(), 1e-6, "1.0 L + 1000.0 mL should equal 2.0 L");
        assertEquals(VolumeUnit.LITRE, result.getUnit(), "Result should be in first operand's unit");
    }

    @Test
    public void testAddition_Volume_CrossUnit_GallonPlusLitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> v2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(2.0, result.getValue(), 1e-5, "1.0 gallon + 3.78541 L should equal 2.0 gallon");
    }

    @Test
    public void testAddition_Volume_ExplicitTargetUnit_Millilitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = v1.add(v2, VolumeUnit.MILLILITRE);
        assertEquals(2000.0, result.getValue(), 1e-6, "1.0 L + 1000.0 mL should equal 2000.0 mL");
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit(), "Result should be in millilitre");
    }

    @Test
    public void testAddition_Volume_ExplicitTargetUnit_Gallon() {
        Quantity<VolumeUnit> v1 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.add(v2, VolumeUnit.GALLON);
        assertEquals(2.0, result.getValue(), 1e-5, "3.78541 L + 3.78541 L should equal 2.0 gallon");
        assertEquals(VolumeUnit.GALLON, result.getUnit(), "Result should be in gallon");
    }

    @Test
    public void testAddition_Volume_WithZero() {
        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = v1.add(v2);
        assertEquals(5.0, result.getValue(), 1e-6, "Adding zero should return original value");
    }

    @Test
    public void testVolumeUnit_ConversionMethods() {
        assertEquals(1.0, VolumeUnit.LITRE.convertToBaseUnit(1.0), 1e-6);
        assertEquals(0.001, VolumeUnit.MILLILITRE.convertToBaseUnit(1.0), 1e-6);
        assertEquals(3.78541, VolumeUnit.GALLON.convertToBaseUnit(1.0), 1e-5);
        
        assertEquals(1.0, VolumeUnit.LITRE.convertFromBaseUnit(1.0), 1e-6);
        assertEquals(1000.0, VolumeUnit.MILLILITRE.convertFromBaseUnit(1.0), 1e-6);
        assertEquals(0.264172, VolumeUnit.GALLON.convertFromBaseUnit(1.0), 1e-6);
    }

    // UC12: Subtraction and Division Operations Tests
    @Test
    public void testSubtraction_SameUnit_FeetMinusFeet() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = l1.subtract(l2);
        assertEquals(5.0, result.getValue(), 1e-6, "10.0 ft - 5.0 ft should equal 5.0 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result should be in feet");
    }

    @Test
    public void testSubtraction_SameUnit_LitreMinusLitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(10.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(3.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.subtract(v2);
        assertEquals(7.0, result.getValue(), 1e-6, "10.0 L - 3.0 L should equal 7.0 L");
        assertEquals(VolumeUnit.LITRE, result.getUnit(), "Result should be in litre");
    }

    @Test
    public void testSubtraction_CrossUnit_FeetMinusInches() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(6.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = l1.subtract(l2);
        assertEquals(9.5, result.getValue(), 1e-6, "10.0 ft - 6.0 in should equal 9.5 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result should be in feet");
    }

    @Test
    public void testSubtraction_CrossUnit_InchesMinusFeet() {
        Quantity<LengthUnit> l1 = new Quantity<>(120.0, LengthUnit.INCH);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = l1.subtract(l2);
        assertEquals(60.0, result.getValue(), 1e-6, "120.0 in - 5.0 ft should equal 60.0 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result should be in inches");
    }

    @Test
    public void testSubtraction_ExplicitTargetUnit_Feet() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(6.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = l1.subtract(l2, LengthUnit.FEET);
        assertEquals(9.5, result.getValue(), 1e-6, "10.0 ft - 6.0 in should equal 9.5 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result should be in feet");
    }

    @Test
    public void testSubtraction_ExplicitTargetUnit_Inches() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(6.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = l1.subtract(l2, LengthUnit.INCH);
        assertEquals(114.0, result.getValue(), 1e-6, "10.0 ft - 6.0 in should equal 114.0 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result should be in inches");
    }

    @Test
    public void testSubtraction_ExplicitTargetUnit_Millilitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v1.subtract(v2, VolumeUnit.MILLILITRE);
        assertEquals(3000.0, result.getValue(), 1e-6, "5.0 L - 2.0 L should equal 3000.0 mL");
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit(), "Result should be in millilitre");
    }

    @Test
    public void testSubtraction_ResultingInNegative() {
        Quantity<LengthUnit> l1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = l1.subtract(l2);
        assertEquals(-5.0, result.getValue(), 1e-6, "5.0 ft - 10.0 ft should equal -5.0 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result should be in feet");
    }

    @Test
    public void testSubtraction_ResultingInZero() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(120.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = l1.subtract(l2);
        assertEquals(0.0, result.getValue(), 1e-6, "10.0 ft - 120.0 in should equal 0.0 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result should be in feet");
    }

    @Test
    public void testSubtraction_WithZeroOperand() {
        Quantity<LengthUnit> l1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(0.0, LengthUnit.INCH);
        Quantity<LengthUnit> result = l1.subtract(l2);
        assertEquals(5.0, result.getValue(), 1e-6, "5.0 ft - 0.0 in should equal 5.0 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result should be in feet");
    }

    @Test
    public void testSubtraction_WithNegativeValues() {
        Quantity<LengthUnit> l1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(-2.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = l1.subtract(l2);
        assertEquals(7.0, result.getValue(), 1e-6, "5.0 ft - (-2.0 ft) should equal 7.0 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result should be in feet");
    }

    @Test
    public void testSubtraction_NonCommutative() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> result1 = l1.subtract(l2);
        Quantity<LengthUnit> result2 = l2.subtract(l1);
        assertEquals(5.0, result1.getValue(), 1e-6, "10.0 ft - 5.0 ft should equal 5.0 ft");
        assertEquals(-5.0, result2.getValue(), 1e-6, "5.0 ft - 10.0 ft should equal -5.0 ft");
    }

    @Test
    public void testSubtraction_NullOperand() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            l1.subtract(null);
        }, "Subtracting null should throw IllegalArgumentException");
    }

    @Test
    public void testSubtraction_NullTargetUnit() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            l1.subtract(l2, null);
        }, "Null target unit should throw IllegalArgumentException");
    }

    @Test
    public void testSubtraction_Immutability() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = l1.subtract(l2);
        assertEquals(10.0, l1.getValue(), 1e-6, "Original l1 should remain unchanged");
        assertEquals(5.0, l2.getValue(), 1e-6, "Original l2 should remain unchanged");
    }

    @Test
    public void testDivision_SameUnit_FeetDividedByFeet() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(2.0, LengthUnit.FEET);
        double result = l1.divide(l2);
        assertEquals(5.0, result, 1e-6, "10.0 ft ÷ 2.0 ft should equal 5.0");
    }

    @Test
    public void testDivision_SameUnit_LitreDividedByLitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(10.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(5.0, VolumeUnit.LITRE);
        double result = v1.divide(v2);
        assertEquals(2.0, result, 1e-6, "10.0 L ÷ 5.0 L should equal 2.0");
    }

    @Test
    public void testDivision_CrossUnit_FeetDividedByInches() {
        Quantity<LengthUnit> l1 = new Quantity<>(24.0, LengthUnit.INCH);
        Quantity<LengthUnit> l2 = new Quantity<>(2.0, LengthUnit.FEET);
        double result = l1.divide(l2);
        assertEquals(1.0, result, 1e-6, "24.0 in ÷ 2.0 ft should equal 1.0");
    }

    @Test
    public void testDivision_CrossUnit_KilogramDividedByGram() {
        Quantity<WeightUnit> w1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(2000.0, WeightUnit.GRAM);
        double result = w1.divide(w2);
        assertEquals(1.0, result, 1e-6, "2.0 kg ÷ 2000.0 g should equal 1.0");
    }

    @Test
    public void testDivision_RatioGreaterThanOne() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(2.0, LengthUnit.FEET);
        double result = l1.divide(l2);
        assertEquals(5.0, result, 1e-6, "10.0 ft ÷ 2.0 ft should equal 5.0");
    }

    @Test
    public void testDivision_RatioLessThanOne() {
        Quantity<LengthUnit> l1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(10.0, LengthUnit.FEET);
        double result = l1.divide(l2);
        assertEquals(0.5, result, 1e-6, "5.0 ft ÷ 10.0 ft should equal 0.5");
    }

    @Test
    public void testDivision_RatioEqualToOne() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(10.0, LengthUnit.FEET);
        double result = l1.divide(l2);
        assertEquals(1.0, result, 1e-6, "10.0 ft ÷ 10.0 ft should equal 1.0");
    }

    @Test
    public void testDivision_NonCommutative() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        double result1 = l1.divide(l2);
        double result2 = l2.divide(l1);
        assertEquals(2.0, result1, 1e-6, "10.0 ft ÷ 5.0 ft should equal 2.0");
        assertEquals(0.5, result2, 1e-6, "5.0 ft ÷ 10.0 ft should equal 0.5");
    }

    @Test
    public void testDivision_ByZero() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(0.0, LengthUnit.FEET);
        assertThrows(ArithmeticException.class, () -> {
            l1.divide(l2);
        }, "Division by zero should throw ArithmeticException");
    }

    @Test
    public void testDivision_NullOperand() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            l1.divide(null);
        }, "Dividing by null should throw IllegalArgumentException");
    }

    @Test
    public void testDivision_Immutability() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(2.0, LengthUnit.FEET);
        double result = l1.divide(l2);
        assertEquals(10.0, l1.getValue(), 1e-6, "Original l1 should remain unchanged");
        assertEquals(2.0, l2.getValue(), 1e-6, "Original l2 should remain unchanged");
    }

    @Test
    public void testSubtraction_AllMeasurementCategories() {
        // Length
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        assertEquals(5.0, l1.subtract(l2).getValue(), 1e-6, "Length subtraction should work");
        
        // Weight
        Quantity<WeightUnit> w1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        assertEquals(5.0, w1.subtract(w2).getValue(), 1e-6, "Weight subtraction should work");
        
        // Volume
        Quantity<VolumeUnit> v1 = new Quantity<>(10.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(5.0, VolumeUnit.LITRE);
        assertEquals(5.0, v1.subtract(v2).getValue(), 1e-6, "Volume subtraction should work");
    }

    @Test
    public void testDivision_AllMeasurementCategories() {
        // Length
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        assertEquals(2.0, l1.divide(l2), 1e-6, "Length division should work");
        
        // Weight
        Quantity<WeightUnit> w1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        assertEquals(2.0, w1.divide(w2), 1e-6, "Weight division should work");
        
        // Volume
        Quantity<VolumeUnit> v1 = new Quantity<>(10.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(5.0, VolumeUnit.LITRE);
        assertEquals(2.0, v1.divide(v2), 1e-6, "Volume division should work");
    }

    // UC13: Centralized Arithmetic Logic Tests
    @Test
    public void testRefactoring_ValidationConsistency_NullOperand() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        
        // All operations should throw same exception for null operand
        Exception addEx = assertThrows(IllegalArgumentException.class, () -> l1.add(null));
        Exception subtractEx = assertThrows(IllegalArgumentException.class, () -> l1.subtract(null));
        Exception divideEx = assertThrows(IllegalArgumentException.class, () -> l1.divide(null));
        
        assertEquals(addEx.getMessage(), subtractEx.getMessage(), "Add and subtract should have same null error message");
        assertEquals(addEx.getMessage(), divideEx.getMessage(), "Add and divide should have same null error message");
    }

    @Test
    public void testRefactoring_ValidationConsistency_CrossCategory() {
        // Cross-category operations are prevented at compile time by generics
        // This test verifies that the validation logic works for same-category operations
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(5.0, LengthUnit.FEET);
        
        // These should work fine (same category)
        assertDoesNotThrow(() -> length1.add(length2));
        assertDoesNotThrow(() -> length1.subtract(length2));
        assertDoesNotThrow(() -> length1.divide(length2));
        
        // The cross-category prevention is enforced by the type system at compile time
        // which is actually better than runtime checking
    }

    @Test
    public void testRefactoring_ArithmeticOperation_ADD() {
        // Test the enum directly (using reflection to access private enum)
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = l1.add(l2);
        assertEquals(15.0, result.getValue(), 1e-6, "ADD operation should work correctly");
    }

    @Test
    public void testRefactoring_ArithmeticOperation_SUBTRACT() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = l1.subtract(l2);
        assertEquals(5.0, result.getValue(), 1e-6, "SUBTRACT operation should work correctly");
    }

    @Test
    public void testRefactoring_ArithmeticOperation_DIVIDE() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        double result = l1.divide(l2);
        assertEquals(2.0, result, 1e-6, "DIVIDE operation should work correctly");
    }

    @Test
    public void testRefactoring_DivisionByZero_ConsistentHandling() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(0.0, LengthUnit.FEET);
        
        ArithmeticException ex = assertThrows(ArithmeticException.class, () -> l1.divide(l2));
        assertEquals("Cannot divide by zero", ex.getMessage(), "Division by zero should have consistent message");
    }

    @Test
    public void testRefactoring_UC12_BehaviorPreserved_Addition() {
        // Verify all UC12 addition behavior is preserved
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCH);
        
        Quantity<LengthUnit> result1 = l1.add(l2);
        assertEquals(2.0, result1.getValue(), 1e-6, "Addition behavior should be preserved");
        assertEquals(LengthUnit.FEET, result1.getUnit(), "Addition result unit should be preserved");
        
        Quantity<LengthUnit> result2 = l1.add(l2, LengthUnit.INCH);
        assertEquals(24.0, result2.getValue(), 1e-6, "Addition with target unit should be preserved");
        assertEquals(LengthUnit.INCH, result2.getUnit(), "Addition target unit should be preserved");
    }

    @Test
    public void testRefactoring_UC12_BehaviorPreserved_Subtraction() {
        // Verify all UC12 subtraction behavior is preserved
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(6.0, LengthUnit.INCH);
        
        Quantity<LengthUnit> result1 = l1.subtract(l2);
        assertEquals(9.5, result1.getValue(), 1e-6, "Subtraction behavior should be preserved");
        assertEquals(LengthUnit.FEET, result1.getUnit(), "Subtraction result unit should be preserved");
        
        Quantity<LengthUnit> result2 = l1.subtract(l2, LengthUnit.INCH);
        assertEquals(114.0, result2.getValue(), 1e-6, "Subtraction with target unit should be preserved");
        assertEquals(LengthUnit.INCH, result2.getUnit(), "Subtraction target unit should be preserved");
    }

    @Test
    public void testRefactoring_UC12_BehaviorPreserved_Division() {
        // Verify all UC12 division behavior is preserved
        Quantity<LengthUnit> l1 = new Quantity<>(24.0, LengthUnit.INCH);
        Quantity<LengthUnit> l2 = new Quantity<>(2.0, LengthUnit.FEET);
        
        double result = l1.divide(l2);
        assertEquals(1.0, result, 1e-6, "Division behavior should be preserved");
    }

    @Test
    public void testRefactoring_Immutability_Preserved() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        
        // Perform operations
        l1.add(l2);
        l1.subtract(l2);
        l1.divide(l2);
        
        // Verify originals unchanged
        assertEquals(10.0, l1.getValue(), 1e-6, "Original l1 should remain unchanged");
        assertEquals(5.0, l2.getValue(), 1e-6, "Original l2 should remain unchanged");
    }

    @Test
    public void testRefactoring_AllCategories_WorkCorrectly() {
        // Length
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        assertEquals(15.0, l1.add(l2).getValue(), 1e-6, "Length addition should work");
        assertEquals(5.0, l1.subtract(l2).getValue(), 1e-6, "Length subtraction should work");
        assertEquals(2.0, l1.divide(l2), 1e-6, "Length division should work");
        
        // Weight
        Quantity<WeightUnit> w1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        assertEquals(15.0, w1.add(w2).getValue(), 1e-6, "Weight addition should work");
        assertEquals(5.0, w1.subtract(w2).getValue(), 1e-6, "Weight subtraction should work");
        assertEquals(2.0, w1.divide(w2), 1e-6, "Weight division should work");
        
        // Volume
        Quantity<VolumeUnit> v1 = new Quantity<>(10.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(5.0, VolumeUnit.LITRE);
        assertEquals(15.0, v1.add(v2).getValue(), 1e-6, "Volume addition should work");
        assertEquals(5.0, v1.subtract(v2).getValue(), 1e-6, "Volume subtraction should work");
        assertEquals(2.0, v1.divide(v2), 1e-6, "Volume division should work");
    }

    @Test
    public void testRefactoring_TargetUnitValidation_Consistent() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        
        // Both add and subtract should reject null target unit
        assertThrows(IllegalArgumentException.class, () -> l1.add(l2, null));
        assertThrows(IllegalArgumentException.class, () -> l1.subtract(l2, null));
    }

    @Test
    public void testRefactoring_NonCommutative_Properties_Preserved() {
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(5.0, LengthUnit.FEET);
        
        // Subtraction non-commutativity
        assertEquals(5.0, l1.subtract(l2).getValue(), 1e-6, "10 - 5 should equal 5");
        assertEquals(-5.0, l2.subtract(l1).getValue(), 1e-6, "5 - 10 should equal -5");
        
        // Division non-commutativity
        assertEquals(2.0, l1.divide(l2), 1e-6, "10 ÷ 5 should equal 2");
        assertEquals(0.5, l2.divide(l1), 1e-6, "5 ÷ 10 should equal 0.5");
    }
}
