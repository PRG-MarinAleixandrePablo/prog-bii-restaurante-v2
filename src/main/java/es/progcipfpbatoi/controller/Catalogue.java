package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.entidades.producttypes.Product;

public class Catalogue {

    private final ProductInterface productInterface;

    public Catalogue(ProductInterface productInterface) {
        this.productInterface = productInterface;
    }

    public Product findByCod(String cod) {
        return productInterface.findByCod(cod);
    }

}
