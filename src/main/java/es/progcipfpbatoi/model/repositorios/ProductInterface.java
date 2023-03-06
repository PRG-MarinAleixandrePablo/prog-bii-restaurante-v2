package es.progcipfpbatoi.model.repositorios;

import es.progcipfpbatoi.model.entidades.producttypes.Product;

import java.util.ArrayList;

public interface ProductInterface {
    ArrayList<Product> findAll(Class<? extends Product> productClass);

    Product findByCod(String cod);
}
