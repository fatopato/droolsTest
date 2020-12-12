package com.javainuse.model;

import java.util.HashMap;

public class Campaign {
    private Long id;
    private String name;
    private String type;
    private Benefit benefit;
    private Double limit;
    private PaymentMethod paymentMethod;
    private HashMap<String, Object> parameters = new HashMap<>();

    public Campaign() {
    }

    public Campaign(Long id, String name, String type, Benefit benefit, Double limit, PaymentMethod paymentMethod, HashMap<String, Object> parameters) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.benefit = benefit;
        this.limit = limit;
        this.paymentMethod = paymentMethod;
        this.parameters = parameters;
    }

    public Campaign(Long id, String name, String type, Benefit benefit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.benefit = benefit;
    }

    public Campaign(Long id, String name, String type, Benefit benefit, Double limit, HashMap<String, Object> parameters) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.benefit = benefit;
        this.limit = limit;
        this.parameters = parameters;
    }

    public Campaign(Long id, String name, String type, Benefit benefit, HashMap<String, Object> parameters) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.benefit = benefit;
        this.parameters = parameters;
    }

    public Campaign(Long id, String name, String type, Benefit benefit, Double limit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.benefit = benefit;
        this.limit = limit;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", benefit=" + benefit +
                ", limit=" + limit +
                ", paymentMethod=" + paymentMethod +
                ", parameters=" + parameters +
                '}';
    }

    public HashMap<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
