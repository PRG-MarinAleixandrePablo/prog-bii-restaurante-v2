package es.progcipfpbatoi.model.dao;

import es.progcipfpbatoi.model.dto.Order;

import java.util.ArrayList;

public interface OrderInterface {
    void add(Order order);

    int size();

    ArrayList<Order> findAll();

    Order findByCod(String code);

}
