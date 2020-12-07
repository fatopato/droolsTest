package com.javainuse.model;

import java.util.ArrayList;

public class Order {

    private Product product;
    // TODO: Simulated payment list
    private ArrayList<Payment> simulatedPaymentOptions;
    private Payment payment;

    public Order() {
    }

    public Order(Product product, Payment payment) {
        this.product = product;
        this.payment = payment;
    }

    public Order(Product product, ArrayList<Payment> simulatedPaymentOptions, Payment payment) {
        this.product = product;
        this.simulatedPaymentOptions = simulatedPaymentOptions;
        this.payment = payment;
    }

    public ArrayList<Payment> getSimulatedPaymentOptions() {
        return simulatedPaymentOptions;
    }

    public void setSimulatedPaymentOptions(ArrayList<Payment> simulatedPaymentOptions) {
        this.simulatedPaymentOptions = simulatedPaymentOptions;
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

    @Override
    public String toString() {
        return "Order{" +
                "product=" + product +
                ", simulatedPaymentOptions=" + simulatedPaymentOptions +
                ", payment=" + payment +
                '}';
    }
}