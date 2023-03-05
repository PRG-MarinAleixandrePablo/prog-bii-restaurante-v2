package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.core.AnsiColor;
import es.progcipfpbatoi.model.entidades.Order;
import es.progcipfpbatoi.model.entidades.Product;
import es.progcipfpbatoi.utils.GestorIO;

public class Waiter {

    private Catalogue catalogue;

    public Waiter(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    /**
     * Creamos un nuevo Pedido
     * @param code
     * @return
     */
    public Order attend(String code) {
        String clientName = getClientName();
        String date =  getCurrentDate();
        Order order = new Order(code, clientName, date);
        askForProducts(order);
        return (order.hasProducts()) ? order : null;
    }

    private void askForProducts(Order order){
        System.out.println("Buenos dias, que deseas Tomar?");
        catalogue.listAll();
        String response = null;
        do {
            response = GestorIO.getString("Introduzca el código del producto que desea añadir " +
                    AnsiColor.colorize(AnsiColor.CYAN, "(0 - Finalizar)"));
            if (response.equals("0")){
                break;
            }
            Product product = getNewProduct(response);
            if (product != null ){
                order.addNewProduct(product);
            }
        } while (true);
    }
    /**
     * Preguntamos al usuario y añadimos un nuevo producto a la orden
     * @return
     */
    private Product getNewProduct(String code) {
        Product product = catalogue.findByCod(code);
        if (product == null) {
            AnsiColor.colorizeOutput(AnsiColor.RED, "El código del producto es erróneo");
            return null;
        }
        System.out.println(
                AnsiColor.colorize(AnsiColor.GREEN, product.getCod()) + " - " + product.getName() + " " +
                        AnsiColor.colorize(AnsiColor.GREEN,  "Añadido"));
        return product;
    }

    private String getClientName() {
        return GestorIO.getString("Introduzca su nombre");
    }

    private String getCurrentDate() {
        return GestorIO.getString("Introduzca la fecha actual en formato "
                + AnsiColor.colorize(AnsiColor.HIGH_INTENSITY,"dd/mm/yyyy"));
    }

}
