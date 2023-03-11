package es.progcipfpbatoi;

import es.progcipfpbatoi.controller.Restaurant;
import es.progcipfpbatoi.menu.MenuApp;
import es.progcipfpbatoi.model.dao.InMemoryOrderRepository;
import es.progcipfpbatoi.model.dao.InMemoryProductRepository;

public class AppRestaurante {

    public static void main(String[] args) {

        //Cargamos la lista de productos y de pedidos
        InMemoryProductRepository productDatabase = new InMemoryProductRepository();
        InMemoryOrderRepository orderDatabase = new InMemoryOrderRepository();

        //Creamos el restaurante
        Restaurant restaurant = new Restaurant(productDatabase, orderDatabase);

        //Creamos un menu para que gestione nuestro restaurante
        MenuApp restaurantMenu = new MenuApp(restaurant);
        restaurantMenu.show();

    }

}
