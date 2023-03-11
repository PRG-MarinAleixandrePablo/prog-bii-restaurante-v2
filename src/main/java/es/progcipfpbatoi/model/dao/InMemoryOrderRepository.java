package es.progcipfpbatoi.model.dao;


import es.progcipfpbatoi.model.dto.Order;

import java.util.ArrayList;

public class InMemoryOrderRepository implements OrderInterface {

    private ArrayList<Order> orderList;

    public InMemoryOrderRepository() {
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
