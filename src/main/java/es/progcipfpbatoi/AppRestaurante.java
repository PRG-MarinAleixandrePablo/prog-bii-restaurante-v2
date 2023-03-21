package es.progcipfpbatoi;

import es.progcipfpbatoi.controller.RestaurantController;
import es.progcipfpbatoi.menu.MenuApp;
import es.progcipfpbatoi.model.repositorios.OrderRepository;
import es.progcipfpbatoi.model.repositorios.ProductRepository;

public class AppRestaurante {

    public static void main(String[] args) {

        //Cargamos la lista de productos y de pedidos
        ProductRepository productDatabase = new ProductRepository();
        OrderRepository orderDatabase = new OrderRepository();

        //Creamos el restaurante
        RestaurantController restaurant = new RestaurantController(productDatabase, orderDatabase);

        //Creamos un menu para que gestione nuestro restaurante
        MenuApp restaurantMenu = new MenuApp(restaurant);
        restaurantMenu.show();

    }

}
