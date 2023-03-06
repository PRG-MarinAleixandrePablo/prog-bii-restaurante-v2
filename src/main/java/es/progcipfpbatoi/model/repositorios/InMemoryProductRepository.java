package es.progcipfpbatoi.model.repositorios;

import es.progcipfpbatoi.controller.Catalogue;
import es.progcipfpbatoi.model.entidades.producttypes.Product;
import es.progcipfpbatoi.model.entidades.producttypes.types.*;

import java.util.ArrayList;

public class InMemoryProductRepository implements ProductInterface{
    private ArrayList<Product> productList;

    public InMemoryProductRepository() {
        productList = new ArrayList<>();
        setDefaultSandwichList();
        setDefaultDrinkList();
        setDefaultStarterList();
        setDefaultDesertList();

    }

    @Override
    public ArrayList<Product> findAll(Class<? extends Product> productClass) {
        ArrayList<Product> productsFiltered = new ArrayList<>();
        for (Product current: productList) {
            if (current.getClass() == productClass) {
                productsFiltered.add(current);
            }
        }

        return productsFiltered;
    }

    public Product findByCod(String cod) {
        for (Product product: productList) {
            if (product.getCod().equals(cod)){
                return product;
            }
        }
        return null;
    }

    private void setDefaultSandwichList() {
        final String productCodePrefix = Catalogue.getCodePrefix(Sandwich.class);
        productList.add(new Sandwich(productCodePrefix + 1, "lechuga, tomate y mayonesa"));
        productList.add(new Sandwich(productCodePrefix + 2, "HUEVO DURO lechuga, tomate y mayonesa"));
        productList.add(new Sandwich(productCodePrefix + 3, "VEGETAL CON QUESO lechuga, tomate y queso"));
        productList.add(new Sandwich(productCodePrefix + 4, "Burger, bacon ahumado, cebolla crujiente y alioli"));
        productList.add(new Sandwich(productCodePrefix + 5, "Pollo, bacon ahumado y salsa brava"));
        productList.add(new Sandwich(productCodePrefix + 6, "Pollo kebab, cebolla, pimiento verde y mayonesa"));
        productList.add(new Sandwich(productCodePrefix + 7, "CUATRO QUESOS: Queso ibérico, queso brie, queso de cabra y crema de queso"));
        productList.add(new Sandwich(productCodePrefix + 8, "CAPRESE: Jamón gran reserva, queso mozzarella, tomate y pesto"));
        productList.add(new Sandwich(productCodePrefix + 9, "Pulled pork y guacamole"));
        productList.add(new Sandwich(productCodePrefix + 10, "PULLED PORK y queso brie"));
        productList.add(new Sandwich(productCodePrefix + 11, "FILETE RUSO, cebolla caramelizada y salsa de queso cheddar"));
        productList.add(new Sandwich(productCodePrefix + 12, "SALMÓN AHUMADO y crema de queso"));
        productList.add(new Sandwich(productCodePrefix + 13, "CARNE MECHADA DESHILACHADA y cebolla crujiente"));
        productList.add(new Sandwich(productCodePrefix + 14, "JAMÓN GRAN RESERVA, tomate y aceite de oliva virgen extra"));
        productList.add(new Sandwich(productCodePrefix + 15, "CARRILLERA AL VINO TINTO y queso ibérico"));
        productList.add(new Sandwich(productCodePrefix + 16, "QUESO IBÉRICO, tortilla de patatas y mayonesa"));
        productList.add(new Sandwich(productCodePrefix + 17, "ALBÓNDIGAS y salsa BBQ"));
        productList.add(new Sandwich(productCodePrefix + 18, "Pollo, cebolla caramelizada y mayonesa trufada"));
        Product product = new Sandwich(productCodePrefix + 19, "CHISTORRA, bacon ahumado y salsa brava");
        product.setDiscount(0.2f);
        productList.add(product);
        productList.add(new Sandwich(productCodePrefix + 20, "Tortilla de patatas"));
    }

    private void setDefaultDrinkList() {
        final String productCodePrefix = Catalogue.getCodePrefix(Drink.class);
        productList.add(new Drink(productCodePrefix + 21, "Coca-Cola"));
        productList.add(new Drink(productCodePrefix + 22, "Agua"));
        productList.add(new Drink(productCodePrefix + 23, "Fanta Limón"));
        productList.add(new Drink(productCodePrefix + 24, "Fanta Naranja"));
        productList.add(new Drink(productCodePrefix + 25, "Cerveza bote 33cl"));
        productList.add(new Drink(productCodePrefix + 26, "Caña Cerveza"));
        productList.add(new Drink(productCodePrefix + 27, "Jarra Cerveza"));
    }

    private void setDefaultDesertList() {
        final String productCodePrefix = Catalogue.getCodePrefix(Desert.class);
        productList.add(new Desert(productCodePrefix + 28, "Pastel de Queso",
                Characteristic.CELIAC_SUITABLE));
        productList.add(new Desert(productCodePrefix + 29, "Pastel Chocolate"));
        productList.add(new Desert(productCodePrefix + 30, "Helado Chocolate",
                Characteristic.DIABETIC_SUITABLE));
        productList.add(new Desert(productCodePrefix + 31, "Helado Vainilla",
                Characteristic.CELIAC_SUITABLE));
        productList.add(new Desert(productCodePrefix + 32, "Helado Limón",
                Characteristic.CELIAC_SUITABLE, Characteristic.DIABETIC_SUITABLE));
        productList.add(new Desert(productCodePrefix + 33, "Helado Fresa",
                Characteristic.CELIAC_SUITABLE, Characteristic.DIABETIC_SUITABLE));
    }

    private void setDefaultStarterList() {
        final String productCodePrefix = Catalogue.getCodePrefix(Starter.class);
        productList.add(new Starter(productCodePrefix + 34, "Patatas 4 Quesos"));
        productList.add(new Starter(productCodePrefix + 35, "Bolas de pollo"));
        productList.add(new Starter(productCodePrefix + 36, "Aceitunas"));
        productList.add(new Starter(productCodePrefix + 37, "Nachos"));
        productList.add(new Starter(productCodePrefix + 38, "Ensalada de la casa"));
        productList.add(new Starter(productCodePrefix + 39, "Bolas de queso"));
        productList.add(new Starter(productCodePrefix + 40, "Alitas de pollo"));
        productList.add(new Starter(productCodePrefix + 41, "Patatas fritas"));
        productList.add(new Starter(productCodePrefix + 42, "Ensalada cesar"));
    }


}
