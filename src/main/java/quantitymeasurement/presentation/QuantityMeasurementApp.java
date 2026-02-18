package quantitymeasurement.presentation;

import quantitymeasurement.model.Feet;
import quantitymeasurement.service.QuantityService;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
        QuantityService service = new QuantityService();

        Feet feet1 = service.createFeet(1.0);
        Feet feet2 = service.createFeet(1.0);

        boolean result = service.checkEquality(feet1, feet2);
        System.out.println("Are 1.0 ft and 1.0 ft equal? " + result);
    }
}
