package com.javainuse.model;

public class OrderItem {
    private Product product;
    private Payment payment;
    private Campaign campaign;

    public OrderItem() {
    }

    public OrderItem(Product product, Payment payment) {
        this.product = product;
        this.payment = payment;
    }

    public OrderItem(Product product, Payment payment, Campaign campaign) {
        this.product = product;
        this.payment = payment;
        this.campaign = campaign;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", payment=" + payment +
                ", campaign=" + campaign +
                '}';
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
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
