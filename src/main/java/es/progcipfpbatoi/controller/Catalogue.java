package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.entidades.producttypes.Product;
import es.progcipfpbatoi.model.entidades.producttypes.types.Desert;
import es.progcipfpbatoi.model.entidades.producttypes.types.Drink;
import es.progcipfpbatoi.model.entidades.producttypes.types.Sandwich;
import es.progcipfpbatoi.model.entidades.producttypes.types.Starter;
import es.progcipfpbatoi.model.repositorios.ProductInterface;
import es.progcipfpbatoi.views.types.MenuCardDrinksView;
import es.progcipfpbatoi.views.types.MenuCardStartersView;
import es.progcipfpbatoi.views.types.MenuCardViewList;

public class Catalogue {

    private final ProductInterface productInterface;

    public Catalogue(ProductInterface productInterface) {
        this.productInterface = productInterface;
    }

    public void listAll(Class type) {

        MenuCardViewList menuCardView;

        if (type == Drink.class) {
            menuCardView = new MenuCardDrinksView(productInterface.findAll(type));
        } else if (type == Starter.class) {
            menuCardView = new MenuCardStartersView(productInterface.findAll(type));
        } else {
            menuCardView = new MenuCardViewList(productInterface.findAll(type));
        }

        menuCardView.show();
    }

    public Product findByCod(String cod) {
        return productInterface.findByCod(cod);
    }

    public static String getCodePrefix(Class classType) {
        if (classType == Desert.class) {
            return "p";
        } else if (classType == Drink.class) {
            return "b";
        } else if (classType == Sandwich.class) {
            return "m";
        } else if (classType == Starter.class) {
            return "e";
        } else {
            assert false;
        }
        return null;
    }
}
