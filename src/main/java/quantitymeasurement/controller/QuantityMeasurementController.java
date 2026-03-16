package quantitymeasurement.controller;

import quantitymeasurement.dto.QuantityDTO;
import quantitymeasurement.exception.QuantityMeasurementException;
import quantitymeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public void performEquality(QuantityDTO q1, QuantityDTO q2) {
        try {
            boolean result = service.compare(q1, q2);
            System.out.println(q1.getValue() + " " + q1.getUnit()
                    + " equals " + q2.getValue() + " " + q2.getUnit()
                    + " : " + result);
        } catch (QuantityMeasurementException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    public void performConversion(QuantityDTO q, String targetUnit) {
        try {
            QuantityDTO result = service.convert(q, targetUnit);
            System.out.println(q.getValue() + " " + q.getUnit()
                    + " -> " + result.getValue() + " " + result.getUnit());
        } catch (QuantityMeasurementException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    public void performAddition(QuantityDTO q1, QuantityDTO q2) {
        try {
            QuantityDTO result = service.add(q1, q2);
            System.out.println(q1.getValue() + " " + q1.getUnit()
                    + " + " + q2.getValue() + " " + q2.getUnit()
                    + " = " + result.getValue() + " " + result.getUnit());
        } catch (QuantityMeasurementException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    public void performSubtraction(QuantityDTO q1, QuantityDTO q2) {
        try {
            QuantityDTO result = service.subtract(q1, q2);
            System.out.println(q1.getValue() + " " + q1.getUnit()
                    + " - " + q2.getValue() + " " + q2.getUnit()
                    + " = " + result.getValue() + " " + result.getUnit());
        } catch (QuantityMeasurementException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    public void performDivision(QuantityDTO q1, QuantityDTO q2) {
        try {
            double result = service.divide(q1, q2);
            System.out.println(q1.getValue() + " " + q1.getUnit()
                    + " / " + q2.getValue() + " " + q2.getUnit()
                    + " = " + result);
        } catch (QuantityMeasurementException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
