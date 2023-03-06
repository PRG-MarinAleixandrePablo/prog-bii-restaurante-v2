package es.progcipfpbatoi.model.entidades.producttypes.types;

import es.progcipfpbatoi.model.entidades.producttypes.Product;

import java.util.HashSet;
import java.util.List;

public class Desert extends Product {

   private HashSet<Characteristic> characteristic;

    public Desert(String cod, String name,
                  float prize, float disccount, float vat, Characteristic... characteristic) {
        super(cod, name, prize, disccount, vat);
        this.characteristic = new HashSet<>(List.of(characteristic));
    }

    public Desert(String cod, String name, Characteristic... characteristic) {
        super(cod, name);
    }

}