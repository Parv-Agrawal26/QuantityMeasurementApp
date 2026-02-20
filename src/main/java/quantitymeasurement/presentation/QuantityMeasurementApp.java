package quantitymeasurement.presentation;

import quantitymeasurement.service.QuantityService;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
        QuantityService service = new QuantityService();

        boolean feetResult = service.checkFeetEquality(1.0, 1.0);
        System.out.println("Are 1.0 ft and 1.0 ft equal? " + feetResult);

        boolean inchesResult = service.checkInchesEquality(1.0, 1.0);
        System.out.println("Are 1.0 inch and 1.0 inch equal? " + inchesResult);
    }
}
