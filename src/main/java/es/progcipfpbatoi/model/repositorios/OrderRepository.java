package es.progcipfpbatoi.model.repositorios;


import es.progcipfpbatoi.model.entidades.Order;

import java.util.ArrayList;

public class OrderRepository implements OrderInterface {

    private ArrayList<Order> orderList;

    public OrderRepository() {
        this.orderList = new ArrayList<>();
    }

    @Override
    public void add(Order order) {
        this.orderList.add(order);
    }

    @Override
    public int size() {
        return this.orderList.size();
    }

    @Override
    public ArrayList<Order> findAll() {
        return orderList;
    }

    @Override
    public Order findByCod(String code) {

        Order orderBuscada = new Order(code);
        if (orderList.contains(orderBuscada)) {
            return orderList.get(orderList.indexOf(orderBuscada));
        }

        return null;
    }
}
