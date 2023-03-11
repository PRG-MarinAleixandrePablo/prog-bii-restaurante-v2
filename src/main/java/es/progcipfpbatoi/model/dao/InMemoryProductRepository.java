package es.progcipfpbatoi.model.dao;

import es.progcipfpbatoi.model.dto.producttypes.Product;
import es.progcipfpbatoi.model.dto.producttypes.types.*;

import java.util.ArrayList;

public class InMemoryProductRepository implements ProductInterface{
    private ArrayList<Product> productList;

    private int assignedCode;

    public InMemoryProductRepository() {
        assignedCode = 1;
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
            if (product.containsThisCode(cod)){
                return product;
            }
        }
        return null;
    }

    private void setDefaultSandwichList() {

        productList.add(new Sandwich(String.valueOf(assignedCode++), "lechuga, tomate y mayonesa"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "HUEVO DURO lechuga, tomate y mayonesa"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "VEGETAL CON QUESO lechuga, tomate y queso"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "Burger, bacon ahumado, cebolla crujiente y alioli"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "Pollo, bacon ahumado y salsa brava"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "Pollo kebab, cebolla, pimiento verde y mayonesa"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "CUATRO QUESOS: Queso ibérico, queso brie, queso de cabra y crema de queso"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "CAPRESE: Jamón gran reserva, queso mozzarella, tomate y pesto"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "Pulled pork y guacamole"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "PULLED PORK y queso brie"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "FILETE RUSO, cebolla caramelizada y salsa de queso cheddar"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "SALMÓN AHUMADO y crema de queso"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "CARNE MECHADA DESHILACHADA y cebolla crujiente"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "JAMÓN GRAN RESERVA, tomate y aceite de oliva virgen extra"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "CARRILLERA AL VINO TINTO y queso ibérico"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "QUESO IBÉRICO, tortilla de patatas y mayonesa"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "ALBÓNDIGAS y salsa BBQ"));
        productList.add(new Sandwich(String.valueOf(assignedCode++), "Pollo, cebolla caramelizada y mayonesa trufada"));
        Product product = new Sandwich(String.valueOf(assignedCode++), "CHISTORRA, bacon ahumado y salsa brava");
        product.setDiscount(0.2f);
        productList.add(product);
        productList.add(new Sandwich(String.valueOf(assignedCode++), "Tortilla de patatas"));
    }

    private void setDefaultDrinkList() {
        productList.add(new Drink(String.valueOf(assignedCode++), "Coca-Cola"));
        productList.add(new Drink(String.valueOf(assignedCode++), "Agua"));
        productList.add(new Drink(String.valueOf(assignedCode++), "Fanta Limón"));
        productList.add(new Drink(String.valueOf(assignedCode++), "Fanta Naranja"));
        productList.add(new Drink(String.valueOf(assignedCode++), "Cerveza bote 33cl"));
        productList.add(new Drink(String.valueOf(assignedCode++), "Caña Cerveza"));
        productList.add(new Drink(String.valueOf(assignedCode++), "Jarra Cerveza"));
    }

    private void setDefaultDesertList() {
        productList.add(new Desert(String.valueOf(assignedCode++), "Pastel de Queso",
                Characteristic.CELIAC_SUITABLE));
        productList.add(new Desert(String.valueOf(assignedCode++), "Pastel Chocolate"));
        productList.add(new Desert(String.valueOf(assignedCode++), "Helado Chocolate",
                Characteristic.DIABETIC_SUITABLE));
        productList.add(new Desert(String.valueOf(assignedCode++), "Helado Vainilla",
                Characteristic.CELIAC_SUITABLE));
        productList.add(new Desert(String.valueOf(assignedCode++), "Helado Limón",
                Characteristic.CELIAC_SUITABLE, Characteristic.DIABETIC_SUITABLE));
        productList.add(new Desert(String.valueOf(assignedCode++), "Helado Fresa",
                Characteristic.CELIAC_SUITABLE, Characteristic.DIABETIC_SUITABLE));
    }

    private void setDefaultStarterList() {
        productList.add(new Starter(String.valueOf(assignedCode++), "Patatas 4 Quesos"));
        productList.add(new Starter(String.valueOf(assignedCode++), "Bolas de pollo"));
        productList.add(new Starter(String.valueOf(assignedCode++), "Aceitunas"));
        productList.add(new Starter(String.valueOf(assignedCode++), "Nachos"));
        productList.add(new Starter(String.valueOf(assignedCode++), "Ensalada de la casa"));
        productList.add(new Starter(String.valueOf(assignedCode++), "Bolas de queso"));
        productList.add(new Starter(String.valueOf(assignedCode++), "Alitas de pollo"));
        productList.add(new Starter(String.valueOf(assignedCode++), "Patatas fritas"));
        productList.add(new Starter(String.valueOf(assignedCode++), "Ensalada cesar"));
    }
}
