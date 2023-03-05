package es.progcipfpbatoi.model.repositorios;

import es.progcipfpbatoi.model.entidades.Product;

import java.util.ArrayList;

public class ProductRepository implements ProductInterface{

    public static String CODE_PREFIX = "p";
    private ArrayList<Product> productList;

    public ProductRepository() {

       setDefaultProductList();

    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    public ArrayList<Product> findAll() {
        return productList;
    }

    public Product findByCod(String cod) {
        for (Product product: productList) {
            if (product.getCod().equals(cod)){
                return product;
            }
        }
        return null;
    }

    public boolean remove(String cod) {
        Product productToRemove = findByCod(cod);
        if (productToRemove != null) {
            productList.remove(productToRemove);
            return true;
        }
        return false;
    }

    public String getNextProductCode() {
        return CODE_PREFIX + productList.size();
    }

    private void setDefaultProductList() {

        productList = new ArrayList<>();
        add(new Product(CODE_PREFIX + 1, "lechuga, tomate y mayonesa"));
        add(new Product(CODE_PREFIX + 2, "HUEVO DURO lechuga, tomate y mayonesa"));
        add(new Product(CODE_PREFIX + 3, "VEGETAL CON QUESO lechuga, tomate y queso"));
        add(new Product(CODE_PREFIX + 4, "Burger, bacon ahumado, cebolla crujiente y alioli"));
        add(new Product(CODE_PREFIX + 5, "Pollo, bacon ahumado y salsa brava"));
        add(new Product(CODE_PREFIX + 6, "Pollo kebab, cebolla, pimiento verde y mayonesa"));
        add(new Product(CODE_PREFIX + 7, "CUATRO QUESOS: Queso ibérico, queso brie, queso de cabra y crema de queso"));
        add(new Product(CODE_PREFIX + 8, "CAPRESE: Jamón gran reserva, queso mozzarella, tomate y pesto"));
        add(new Product(CODE_PREFIX + 9, "Pulled pork y guacamole"));
        add(new Product(CODE_PREFIX + 10, "PULLED PORK y queso brie"));
        add(new Product(CODE_PREFIX + 11, "FILETE RUSO, cebolla caramelizada y salsa de queso cheddar"));
        add(new Product(CODE_PREFIX + 12, "SALMÓN AHUMADO y crema de queso"));
        add(new Product(CODE_PREFIX + 13, "CARNE MECHADA DESHILACHADA y cebolla crujiente"));
        add(new Product(CODE_PREFIX + 14, "JAMÓN GRAN RESERVA, tomate y aceite de oliva virgen extra"));
        add(new Product(CODE_PREFIX + 15, "CARRILLERA AL VINO TINTO y queso ibérico"));
        add(new Product(CODE_PREFIX + 16, "QUESO IBÉRICO, tortilla de patatas y mayonesa"));
        add(new Product(CODE_PREFIX + 17, "ALBÓNDIGAS y salsa BBQ"));
        add(new Product(CODE_PREFIX + 18, "Pollo, cebolla caramelizada y mayonesa trufada"));
        Product product = new Product(CODE_PREFIX + 19, "CHISTORRA, bacon ahumado y salsa brava");
        product.setDisccount(0.2f);
        add(product);
        add(new Product(CODE_PREFIX + 20, "Tortilla de patatas"));

    }

}
