package quantitymeasurement.app;

import quantitymeasurement.controller.QuantityMeasurementController;
import quantitymeasurement.dto.QuantityDTO;
import quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import quantitymeasurement.service.IQuantityMeasurementService;
import quantitymeasurement.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityMeasurementCacheRepository repo =
                QuantityMeasurementCacheRepository.getInstance();

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
