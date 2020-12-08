package com.javainuse.model;

public class Campaign {
    private Long id;
    private String name;
    private String type;
    private Benefit benefit;
    private Double limit;

    public Campaign() {
    }

    public Campaign(Long id, String name, String type, Benefit benefit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.benefit = benefit;
    }

    public Campaign(Long id, String name, String type, Benefit benefit, Double limit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.benefit = benefit;
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", benefit=" + benefit +
                ", limit=" + limit +
                '}';
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
