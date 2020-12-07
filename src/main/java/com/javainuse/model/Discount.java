package com.javainuse.model;

public class Discount {
    private String type;
    private Double amount;

    public Discount() {
    }

    public Discount(String type, Double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "type='" + type + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
