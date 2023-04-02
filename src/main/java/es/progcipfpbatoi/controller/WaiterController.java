package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.entidades.producttypes.types.Desert;
import es.progcipfpbatoi.model.entidades.producttypes.types.Drink;
import es.progcipfpbatoi.model.entidades.producttypes.types.Sandwich;
import es.progcipfpbatoi.model.entidades.producttypes.types.Starter;
import es.progcipfpbatoi.model.repositorios.ProductRepository;
import es.progcipfpbatoi.utils.AnsiColor;
import es.progcipfpbatoi.model.entidades.Order;
import es.progcipfpbatoi.model.entidades.producttypes.Product;
import es.progcipfpbatoi.utils.GestorIO;
import es.progcipfpbatoi.utils.Validator;
import es.progcipfpbatoi.view.MenuCardViewList;

public class WaiterController {

    private ProductRepository productRepository;

    public WaiterController(ProductRepository productInterface) {
        this.productRepository = productInterface;
    }

    /**
     * Crea un nuevo pedido con código @code
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

    /**
     * Pregunta al usuario por los productos que desea tomar y
     * los va añadiendo al pedido @order
     */
    private void askForProducts(Order order){
        System.out.println("Buenos días, ¿qué desea tomar?");
        System.out.println("¿Para beber?");
        selectProductsOfType(Drink.class, order);
        System.out.println("¿Desea tomar algo de entrante?");
        selectProductsOfType(Starter.class, order);
        System.out.println("¿Desea tomar algún montadito?");
        selectProductsOfType(Sandwich.class, order);
        System.out.println("¿Y de postre?");
        selectProductsOfType(Desert.class, order);
    }

    /**
     *  Selecciona productos del tipo @productClass y los añade al pedido @order
     *
     * @param productClass
     */
    private void selectProductsOfType(Class productClass, Order order){
        listAllProducts(productClass);
        do {
            Product product = askForNewProduct();
            if (product == null) {
                break;
            }
            if (product.getClass() != productClass) {
                if (!confirmSelection()) {
                    continue;
                }
            }
            addNewProductToOrder(product, order);
        } while (true);

    }

    /**
     * Añade el producto seleccionado @product al pedido @order
     *
     * @param product
     */
    private void addNewProductToOrder(Product product, Order order) {
        order.addNewProduct(product);
        System.out.printf("%s - %s %s \n",
                AnsiColor.colorize(AnsiColor.GREEN, product.getCod()),
                product.getName(),
                AnsiColor.colorize(AnsiColor.GREEN,  "[Añadido]")
        );
    }

    /**
     * Preguntamos al usuario que producto nuevo quiere añadir
     * @return Producto a añadir
     */
    private Product askForNewProduct() {
        do {
            String code = getProductCode();
            if (code == null) {
                return null;
            }
            Product product = productRepository.findByCod(code);
            if (product == null) {
                AnsiColor.errorOutput("El código del producto introducido no existe");
            } else {
                return product;
            }
        } while (true);
    }

    /**
     * Obtenemos el código del producto a introducir / null si no quiere más
     * @return codigo del producto a añadir
     */
    private String getProductCode() {
        do {
            String mensaje = String.format("Introduzca el código del producto que desea añadir %s",
                    AnsiColor.colorize(AnsiColor.CYAN, "(0 - Finalizar)"));
            String productCode = GestorIO.obtenerString(mensaje);
            if (productCode.equalsIgnoreCase("0")){
                return null;
            }else if (isValidProductCode(productCode)){
                return productCode;
            }
            System.out.println("El código de producto introducido no es válido");
        } while (true);
    }

    private String getClientName() {
        return GestorIO.obtenerString("Introduzca su nombre");
    }

    private String getCurrentDate() {
        do {
            String mensaje = String.format("Introduzca la fecha actual en formato %s", AnsiColor.colorize(AnsiColor.HIGH_INTENSITY,"dd/mm/yyyy"));
            String date = GestorIO.obtenerString(mensaje);
            if (isvalidDateFormat(date)){
                return date;
            }
            AnsiColor.errorOutput("El formato introducido no es válido. Recuerde (dd/mm/yyy)");
        } while (true);
    }

    /**
     * Permite validar el formato de la fecha introducido por el usuario
     *
     * @param date
     */
    private boolean isvalidDateFormat(String date) {
        return Validator.isValidateDate(date);
    }

    /**
     * Permite validar el formato del código de producto introducido por el usuario
     *
     * @param productCode
     */
    private boolean isValidProductCode(String productCode) {
        return Validator.isValidProductCode(productCode);
    }

    private boolean confirmSelection() {
        String message = "El producto seleccionado no pertenece a la categoría, desea agregarlo (S/N) ";
        return GestorIO.obtenerString(AnsiColor.colorize(AnsiColor.GREEN, message)).charAt(0) == 'S';
    }

    private void listAllProducts(Class type) {
        MenuCardViewList menuCardView = new MenuCardViewList(productRepository.findAll(type));
        menuCardView.show();
    }
}
