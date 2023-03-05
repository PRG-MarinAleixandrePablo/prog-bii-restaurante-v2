package es.progcipfpbatoi.model.repositorios;

import es.progcipfpbatoi.model.entidades.Order;

import java.util.HashMap;

public class OrderRepository implements OrderInterface {

    private HashMap<String, Order> orderList;

    public OrderRepository() {
        this.orderList = new HashMap<>();
    }

    @Override
    public void put(String code, Order order) {
        this.orderList.put(order.getCode(), order);
    }

    @Override
    public int size() {
        return this.orderList.size();
    }

    @Override
    public HashMap<String, Order> findAll() {
        return orderList;
    }

    @Override
    public Order getByCod(String code) {
        if (!orderList.containsKey(code)) {
            return null;
        }

        return orderList.get(code);
    }
}
