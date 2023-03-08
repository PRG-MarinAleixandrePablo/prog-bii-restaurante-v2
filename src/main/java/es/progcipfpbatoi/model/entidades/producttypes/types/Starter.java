package es.progcipfpbatoi.model.entidades.producttypes.types;

import es.progcipfpbatoi.model.entidades.producttypes.Product;

public class Starter extends Product {

    private int ration;

    public Starter(String cod, String name, float prize, float disccount, float vat) {
        super(cod, name, prize, disccount, vat, "e");
    }

    public Starter(String cod, String name) {
        super(cod, name);
    }

    public int getRation() {
        return ration;
    }
}
