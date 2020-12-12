package com.javainuse.model;

import java.util.ArrayList;

public class Order {

    private ArrayList<OrderItem>  orderItems = new ArrayList<OrderItem>();
    // TODO: Simulated payment list
    private ArrayList<OrderItem> simulatedPaymentOptions = new ArrayList<OrderItem>();
    private Payment payment;

    public Order() {
    }

    public Order(ArrayList<OrderItem> orderItems, ArrayList<OrderItem> simulatedPaymentOptions, Payment payment) {
        this.orderItems = orderItems;
        this.simulatedPaymentOptions = simulatedPaymentOptions;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderItems=" + orderItems +
                ", simulatedPaymentOptions=" + simulatedPaymentOptions +
                ", paymentType='" + payment + '\'' +
                '}';
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public ArrayList<OrderItem> getSimulatedPaymentOptions() {
        return simulatedPaymentOptions;
    }

    public void setSimulatedPaymentOptions(ArrayList<OrderItem> simulatedPaymentOptions) {
        this.simulatedPaymentOptions = simulatedPaymentOptions;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
