package com.javainuse.model;

public class Payment {
    private PaymentMethod method;
    private Discount discount;
    private Double totalAmount;
    private Double finalAmount;

    public Payment() {
    }

    public Payment(PaymentMethod method, Discount discount, Double totalAmount, Double finalAmount) {
        this.method = method;
        this.discount = discount;
        this.totalAmount = totalAmount;
        this.finalAmount = finalAmount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
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
                "type='" + method + '\'' +
                ", discount=" + discount +
                ", totalAmount=" + totalAmount +
                ", finalAmount=" + finalAmount +
                '}';
    }
}
