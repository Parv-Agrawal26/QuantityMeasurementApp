package quantitymeasurement.presentation;

import quantitymeasurement.model.LengthUnit;
import quantitymeasurement.model.QuantityLength;
import quantitymeasurement.service.QuantityService;

public class QuantityMeasurementApp {

    public static void demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
        try {
            double result = QuantityLength.convert(value, fromUnit, toUnit);
            System.out.printf("Converting %.2f %s to %s: %.6f%n", 
                value, fromUnit.name().toLowerCase(), toUnit.name().toLowerCase(), result);
        } catch (IllegalArgumentException e) {
            System.out.println("Conversion error: " + e.getMessage());
        }
    }

    public static void demonstrateLengthConversion(QuantityLength quantity, LengthUnit toUnit) {
        try {
            QuantityLength result = quantity.convertTo(toUnit);
            System.out.printf("Converting %s to %s: %s%n", 
                quantity.toString(), toUnit.name().toLowerCase(), result.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Conversion error: " + e.getMessage());
        }
    }

 
    public static void demonstrateLengthEquality(QuantityLength length1, QuantityLength length2) {
        boolean isEqual = length1.equals(length2);
        System.out.printf("%s equals %s: %b%n", length1.toString(), length2.toString(), isEqual);
    }

  
    public static void demonstrateLengthComparison(double value1, LengthUnit unit1, double value2, LengthUnit unit2) {
        QuantityLength length1 = new QuantityLength(value1, unit1);
        QuantityLength length2 = new QuantityLength(value2, unit2);
        demonstrateLengthEquality(length1, length2);
    }

    public static void main(String[] args) {
        QuantityService service = new QuantityService();

        System.out.println("=== UC5: Unit-to-Unit Conversion Demo ===");
        
     
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCH);
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        demonstrateLengthConversion(36.0, LengthUnit.INCH, LengthUnit.YARDS);
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCH);
        demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCH);
        
        System.out.println();
        
       
        QuantityLength lengthInYards = new QuantityLength(2.0, LengthUnit.YARDS);
        demonstrateLengthConversion(lengthInYards, LengthUnit.INCH);
        
        System.out.println();
     
        demonstrateLengthComparison(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCH);
        demonstrateLengthComparison(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET);
        
        System.out.println();
    
        boolean feetResult = service.checkFeetEquality(1.0, 1.0);
        System.out.println("Are 1.0 ft and 1.0 ft equal? " + feetResult);

        boolean inchesResult = service.checkInchesEquality(1.0, 1.0);
        System.out.println("Are 1.0 inch and 1.0 inch equal? " + inchesResult);
    }
}