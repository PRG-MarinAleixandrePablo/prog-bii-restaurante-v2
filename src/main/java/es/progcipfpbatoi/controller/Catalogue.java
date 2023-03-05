package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.entidades.Product;
import es.progcipfpbatoi.model.repositorios.ProductInterface;
import es.progcipfpbatoi.views.MenuCardViewList;

public class Catalogue {
    private final ProductInterface productInterface;

    public Catalogue(ProductInterface productInterface) {
        this.productInterface = productInterface;
    }

    public void listAll() {
        MenuCardViewList menuCardView = new MenuCardViewList(productInterface.findAll());
        menuCardView.show();
    }

    public Product findByCod(String cod) {
        return productInterface.findByCod(cod);
    }
}
