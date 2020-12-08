package com.javainuse.model;

public class OrderItem {
    private Product product;
    private Payment payment;

    public OrderItem() {
    }

    public OrderItem(Product product, Payment payment) {
        this.product = product;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", payment=" + payment +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
