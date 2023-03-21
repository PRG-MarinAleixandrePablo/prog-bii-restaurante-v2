package es.progcipfpbatoi.menu;

import es.progcipfpbatoi.controller.RestaurantController;
import es.progcipfpbatoi.utils.AnsiColor;
import es.progcipfpbatoi.utils.GestorIO;

public class MenuApp {

    private static final int OPTION_CREATE_ORDER = 1;
    private static final int OPTION_LIST = 2;
    private static final int OPTION_VIEW_ORDER = 3;
    private static final int OPTION_SERVE_ORDER = 4;
    private static final int OPTION_EXIT = 5;

    private RestaurantController restaurant;

    public MenuApp(RestaurantController restaurant) {
        this.restaurant = restaurant;
    }

    public void show() {
        int option;
        do {
            showWelcomeBanner();
            option = this.getUserOption();
            handleOption(option);
        } while (option != OPTION_EXIT);
    }

    private void handleOption(int option){
        if (option == OPTION_CREATE_ORDER) {
            restaurant.attendClient();
        } else if (option == OPTION_LIST) {
            restaurant.listAllOrders();
        }else if (option == OPTION_SERVE_ORDER) {
            restaurant.serveOrder();
        }else if (option == OPTION_VIEW_ORDER) {
            restaurant.viewOrder();
        } else if (option == OPTION_EXIT) {
            showGoodbyeBanner();
        }else {
            AnsiColor.errorOutput("Opción no válida");
        }
    }

    private int getUserOption() {
        System.out.println(OPTION_CREATE_ORDER + ". Crear nuevo pedido");
        System.out.println(OPTION_LIST + ". Listar todos los pedidos");
        System.out.println(OPTION_VIEW_ORDER + ". Visualizar orden");
        System.out.println(OPTION_SERVE_ORDER + ". Servir pedido");
        System.out.println(OPTION_EXIT + ". Salir");
        return GestorIO.obtenerEntero("Selecciona una opción: ");
    }

    private void showWelcomeBanner(){

        System.out.println("==============================================");
        AnsiColor.colorizeOutput(AnsiColor.BLUE, "=== Bienvenido al bar de los 20 Montaditos ===");
        System.out.println("==============================================");

    }

    private void showGoodbyeBanner(){

        System.out.println("==============================================");
        AnsiColor.colorizeOutput(AnsiColor.BLUE, "=========== Esperamos verte pronto ===========");
        System.out.println("==============================================");

    }
}
