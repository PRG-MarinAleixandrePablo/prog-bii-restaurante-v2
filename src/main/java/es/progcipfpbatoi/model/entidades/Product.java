package es.progcipfpbatoi.model.entidades;

public class Product {

    private String cod;

    private String name;

    private float prize;

    private float disccount;

    private float vat;

    public Product(String cod, String name, float prize, float disccount, float vat) {
        this.cod = cod;
        this.name = name;
        this.prize = prize;
        this.disccount = disccount;
        this.vat = vat;
    }

    public Product(String cod, String name) {
        this.cod = cod;
        this.name = name;
        this.disccount = 0f;
        this.prize = 1.25f;
        this.vat = 0.1f;
    }

    public String getCod() {
        return this.cod;
    }

    public float getPrize() {
        return prize * (1 + vat) - (prize * disccount);
    }

    public float getPrizeWithoutDiscount() {
        return prize * (1 + vat);
    }


    public String getName() {
        return name;
    }

    public void setDisccount(float disccount) {
        this.disccount = disccount;
    }

    public float getPercentageDisccount() {
        return disccount * 100;
    }

}
