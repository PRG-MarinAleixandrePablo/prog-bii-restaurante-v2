package es.progcipfpbatoi.model.repositorios;

import es.progcipfpbatoi.model.entidades.Order;

import java.util.ArrayList;

public interface OrderInterface {
    void add(Order order);

    int size();

    ArrayList<Order> findAll();

    Order findByCod(String code);

}
