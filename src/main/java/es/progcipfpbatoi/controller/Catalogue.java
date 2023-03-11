package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.dto.producttypes.Product;
import es.progcipfpbatoi.model.dao.ProductInterface;
import es.progcipfpbatoi.view.MenuCardViewList;

public class Catalogue {

    private final ProductInterface productInterface;

    public Catalogue(ProductInterface productInterface) {
        this.productInterface = productInterface;
    }

    public void listAll(Class type) {

        MenuCardViewList menuCardView;
        menuCardView = new MenuCardViewList(productInterface.findAll(type));


        menuCardView.show();
    }

    public Product findByCod(String cod) {
        return productInterface.findByCod(cod);
    }
}
