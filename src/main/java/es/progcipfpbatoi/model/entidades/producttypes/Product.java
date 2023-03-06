package es.progcipfpbatoi.model.entidades.producttypes;

public abstract class Product {

    private String cod;

    private String name;

    private float prize;

    private float discount;

    private float vat;

    public Product(String cod, String name, float prize, float disccount, float vat) {
        this.cod = cod;
        this.name = name;
        this.prize = prize;
        this.discount = disccount;
        this.vat = vat;
    }

    public Product(String cod, String name) {
        this.cod = cod;
        this.name = name;
        this.discount = 0f;
        this.prize = 1.25f;
        this.vat = 0.1f;
    }

    public String getCod() {
        return this.cod;
    }

    public float getPrize() {
        return prize * (1 + vat) - (prize * discount);
    }

    public float getPrizeWithoutDiscount() {
        return prize * (1 + vat);
    }


    public String getName() {
        return name;
    }

    public void setDiscount(float disccount) {
        this.discount = disccount;
    }

    public float getPercentageDisccount() {
        return discount * 100;
    }

}
