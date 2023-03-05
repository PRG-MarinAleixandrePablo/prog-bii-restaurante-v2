package es.progcipfpbatoi.model.repositorios;

import es.progcipfpbatoi.model.entidades.Order;

import java.util.HashMap;

public interface OrderInterface {
    void put(String code, Order order);

    int size();

    HashMap<String, Order> findAll();

    Order getByCod(String code);

}
