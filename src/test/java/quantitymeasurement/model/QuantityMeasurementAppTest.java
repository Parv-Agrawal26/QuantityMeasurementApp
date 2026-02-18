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
}
