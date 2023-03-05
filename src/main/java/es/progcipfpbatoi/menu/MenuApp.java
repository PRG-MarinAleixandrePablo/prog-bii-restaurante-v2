package es.progcipfpbatoi.menu;

import es.progcipfpbatoi.controller.Restaurant;
import es.progcipfpbatoi.core.AnsiColor;
import es.progcipfpbatoi.utils.GestorIO;

public class MenuApp {

    private final int OPTION_CREATE_ORDER = 1;
    private final int OPTION_LIST = 2;
    private final int OPTION_VIEW_ORDER = 3;
    private final int OPTION_SERVE_ORDER = 4;
    private final int OPTION_EXIT = 5;

    private Restaurant restaurant;

    public MenuApp(Restaurant restaurant) {
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
        if (option == this.OPTION_CREATE_ORDER) {
            restaurant.attendClient();
        } else if (option == this.OPTION_LIST) {
            restaurant.listAllOrders();
        }else if (option == this.OPTION_SERVE_ORDER) {
            restaurant.serveOrder();
        }else if (option == this.OPTION_VIEW_ORDER) {
            restaurant.viewOrder();
        } else if (option == this.OPTION_EXIT) {
            showGoodbyeBanner();
        }else {
            System.out.println("Opción no válida");
        }
    }

    private int getUserOption() {
        System.out.println(this.OPTION_CREATE_ORDER + ". Crear nuevo pedido");
        System.out.println(this.OPTION_LIST + ". Listar todos los pedidos");
        System.out.println(this.OPTION_VIEW_ORDER + ". Visualizar orden");
        System.out.println(this.OPTION_SERVE_ORDER + ". Servir pedido");
        System.out.println(this.OPTION_EXIT + ". Salir");
        return GestorIO.getInt("");
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
