package quantitymeasurement.dao;

import quantitymeasurement.model.Feet;

public class QuantityDAO {
    
    public Feet createFeet(double value) {
        return new Feet(value);
    }
}
