package quantitymeasurement.service;

import quantitymeasurement.dao.QuantityDAO;
import quantitymeasurement.model.Feet;

public class QuantityService {
    private QuantityDAO dao;

    public QuantityService() {
        this.dao = new QuantityDAO();
    }

    public Feet createFeet(double value) {
        return dao.createFeet(value);
    }

    public boolean checkEquality(Feet feet1, Feet feet2) {
        return feet1.equals(feet2);
    }
}
