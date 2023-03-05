package es.progcipfpbatoi.model.entidades;

import java.util.ArrayList;

public class Order {

    private String code;

    private String clientName;

    private String createdOn;

    private boolean served;

    private ArrayList<Product> products;

    public Order(String code, String clientName, String createdOn) {
        this.clientName = clientName;
        this.createdOn = createdOn;
        this.code = code;
        served = false;
        this.products = new ArrayList<>();
    }

    public void addNewProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return "{" +
                " code : " + code +
                ", name : " + clientName +
                ", createdOn : " + createdOn + "\n" +
                "Productos : " + products + "\n" +
                "Precio Total : " + getOrderPrize() +
                '}';
    }

    public String getClientName() {
        return clientName;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public boolean isServed() {
        return served;
    }

    public String getCode() {
        return code;
    }

    public void setServed() {
         served = true;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public boolean hasProducts() {
        return products.size() > 0;
    }

    public double getOrderPrize() {
        double totalPrize = 0;
        for (Product product : products) {
            totalPrize += product.getPrize();
        }
        return totalPrize;
    }

}
