package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.entidades.producttypes.Product;
import es.progcipfpbatoi.model.repositorios.ProductRepository;

public class Catalogue {

    private final ProductRepository productRepository;

    public Catalogue(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findByCod(String cod) {
        return productRepository.findByCod(cod);
    }

}
