package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.repositorios.OrderRepository;
import es.progcipfpbatoi.model.repositorios.ProductRepository;
import es.progcipfpbatoi.utils.AnsiColor;
import es.progcipfpbatoi.model.entidades.Order;
import es.progcipfpbatoi.utils.GestorIO;
import es.progcipfpbatoi.view.OrderView;
import es.progcipfpbatoi.view.OrderViewList;

import java.util.ArrayList;

public class RestaurantController {

    private OrderRepository orderRepository;
    private WaiterController waiter;
    public RestaurantController(ProductRepository productRepository, OrderRepository orderInterface) {
        this.orderRepository = orderInterface;
        this.waiter = new WaiterController(productRepository);
    }

    /**
     *  Registra un nuevo pedido en el restaurante
     */
    public void attendClient() {
        Order order = waiter.attend(getNextOrderCode());
        if (order != null) {
            orderRepository.add(order);
            System.out.println(AnsiColor.colorize(AnsiColor.GREEN, "Pedido registrado con éxito "));
            showOrder(order);
        } else {
            System.out.println("Pedido no registrado por no tener ningún producto");
        }
    }

    /**
     * Lista todas los pedidos
     */
    public void listAllOrders() {
        if (orderRepository.size() == 0) {
            System.out.println(AnsiColor.colorize(AnsiColor.RED, "No existen pedidos en el restaurante"));
        } else {
            OrderViewList orderViewList = new OrderViewList(orderRepository.findAll());
            System.out.println(orderViewList);
        }
    }

    /**
     * Permite acceder a la información de un pedido
     */
    public void viewOrder() {
        listAllOrders();
        if (orderRepository.size() >= 0) {
            String orderCode = GestorIO.obtenerString(AnsiColor.colorize(AnsiColor.HIGH_INTENSITY, "Introduzca el código del pedido que deseas visualizar"));
            Order order = orderRepository.findByCod(orderCode);
            if (order == null) {
                System.out.println(AnsiColor.colorize(AnsiColor.RED, "El pedido introducido no existe"));
            } else {
                showOrder(order);
            }
        }
    }

    /**
     *  Permite marcar una orden como servida
     */
    public void serveOrder() {
        if(!showPendingOrderList()){
            return;
        }
        String orderCode = GestorIO.obtenerString(AnsiColor.colorize(AnsiColor.HIGH_INTENSITY, "Introduzca el código de la orden que desea servir"));
        Order order = orderRepository.findByCod(orderCode);
        if (order == null) {
            System.out.println(AnsiColor.colorize(AnsiColor.RED, "El pedido introducido no existe"));
        } else {
            order.setServed();
            System.out.println(AnsiColor.colorize(AnsiColor.GREEN, "El pedido ha sido marcado como servido"));
        }
    }

    /**
     * muestra la lista de ordenes pendientes de servir
     */
    private boolean showPendingOrderList() {
        ArrayList<Order> pendingServedOrderList = new ArrayList<>();
        for (Order order: orderRepository.findAll()) {
            if (!order.isServed()) {
                pendingServedOrderList.add(order);
            }
        }
        OrderViewList orderViewList = new OrderViewList(pendingServedOrderList);
        orderViewList.show();
        return pendingServedOrderList.size() > 0 ;
    }

    private String getNextOrderCode(){
        return "o" + (orderRepository.size() + 1);
    }

    /**
     * Visualizar una orden en formato tabla
     */
    private void showOrder(Order order) {
        OrderView orderView = new OrderView(order);
        orderView.show();
    }
}
