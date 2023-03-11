package es.progcipfpbatoi.model.dto.producttypes.types;

import es.progcipfpbatoi.model.dto.producttypes.Product;

public class Starter extends Product {

    private int ration;

    public Starter(String cod, String name, float prize, float disccount, float vat) {
        super(cod, name, prize, disccount, vat, "e");
    }

    public Starter(String cod, String name) {
        super(cod, name, "e");
    }

    public int getRation() {
        return ration;
    }

    @Override
    public String getExtras() {
        return String.format("Raciones: %s", ration);
    }
}
