package com.app.quantitymeasurement;

import com.app.quantitymeasurement.controller.QuantityMeasurementController;
import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;
import com.app.quantitymeasurement.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // Use DB-backed repository for smoke test so we validate DB integration.
        QuantityMeasurementDatabaseRepository repo = new QuantityMeasurementDatabaseRepository();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repo);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        System.out.println("=== Length Equality ===");
        controller.performEquality(
                new QuantityDTO(1, "FEET", "LENGTH"),
                new QuantityDTO(12, "INCH", "LENGTH"));

        System.out.println("=== Length Addition ===");
        controller.performAddition(
                new QuantityDTO(1, "FEET", "LENGTH"),
                new QuantityDTO(12, "INCH", "LENGTH"));

        System.out.println("=== Weight Equality ===");
        controller.performEquality(
                new QuantityDTO(1, "KILOGRAM", "WEIGHT"),
                new QuantityDTO(1000, "GRAM", "WEIGHT"));

        System.out.println("=== Temperature Conversion ===");
        controller.performConversion(
                new QuantityDTO(0, "CELSIUS", "TEMPERATURE"), "FAHRENHEIT");

        System.out.println("=== Cross-Category Prevention ===");
        controller.performEquality(
                new QuantityDTO(1, "FEET", "LENGTH"),
                new QuantityDTO(1, "KILOGRAM", "WEIGHT"));
    }
}