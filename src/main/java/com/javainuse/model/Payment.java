package com.javainuse.model;

public class Payment {
    private String type;
    private Discount discount;
    private Double totalAmount;
    private Double finalAmount;

    public Payment() {
    }

    public Payment(String type, Discount discount, Double totalAmount, Double finalAmount) {
        this.type = type;
        this.discount = discount;
        this.totalAmount = totalAmount;
        this.finalAmount = finalAmount;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "type='" + type + '\'' +
                ", discount=" + discount +
                ", totalAmount=" + totalAmount +
                ", finalAmount=" + finalAmount +
                '}';
    }
}
