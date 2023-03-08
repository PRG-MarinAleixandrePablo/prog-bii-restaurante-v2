package es.progcipfpbatoi.model.entidades.producttypes.types;

import es.progcipfpbatoi.model.entidades.producttypes.Product;

public class Drink extends Product {

    private boolean refillable;

    private Size size;

    public Drink(String cod, String name, float prize, float disccount, float vat) {
        super(cod, name, prize, disccount, vat, "b");
        this.refillable = false;
        this.size = Size.NORMAL;
    }

    public Drink(String cod, String name) {
        super(cod, name, 1.0f, 0f, 0.1f, "b");
        this.refillable = false;
        this.size = Size.NORMAL;
    }

    public Size getSize() {
        return size;
    }

    public boolean isRefillable() {
        return refillable;
    }
}
