package es.progcipfpbatoi.model.repositorios;

import es.progcipfpbatoi.model.entidades.Product;

import java.util.ArrayList;

public interface ProductInterface {
    void add(Product product);
    ArrayList<Product> findAll();

    Product findByCod(String cod);

    boolean remove(String cod);

    String getNextProductCode();
}
