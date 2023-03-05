package es.progcipfpbatoi;

import es.progcipfpbatoi.controller.Restaurant;
import es.progcipfpbatoi.menu.MenuApp;
import es.progcipfpbatoi.model.repositorios.OrderRepository;
import es.progcipfpbatoi.model.repositorios.ProductRepository;

public class TestRestaurant {

    public static void main(String[] args) {

        //Cargamos la lista de productos y de pedidos
        ProductRepository productDatabase = new ProductRepository();
        OrderRepository orderDatabase = new OrderRepository();

        //Creamos el restaurante
        Restaurant restaurant = new Restaurant(productDatabase, orderDatabase);

        //Creamos un menu para que gestione nuestro restaurante
        MenuApp restaurantMenu = new MenuApp(restaurant);
        restaurantMenu.show();

    }

}
