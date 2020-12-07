package com.javainuse.model;

public class Benefit {
    private Long id;
    private String type;
    private Discount discount;

    public Benefit() {
    }

    public Benefit(Long id, String type, Discount discount) {
        this.id = id;
        this.type = type;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Benefit{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", discount=" + discount +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
