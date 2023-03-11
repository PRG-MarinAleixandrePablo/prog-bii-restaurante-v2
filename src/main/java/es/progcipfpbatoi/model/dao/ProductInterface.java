package es.progcipfpbatoi.model.dao;

import es.progcipfpbatoi.model.dto.producttypes.Product;

import java.util.ArrayList;

public interface ProductInterface {
    ArrayList<Product> findAll(Class<? extends Product> productClass);

    Product findByCod(String cod);
}
