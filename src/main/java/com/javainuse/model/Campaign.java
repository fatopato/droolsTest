package com.javainuse.model;

public class Campaign {
    private Long id;
    private String name;
    private String type;
    private Benefit benefit;

    public Campaign() {
    }

    public Campaign(Long id, String name, String type, Benefit benefit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.benefit = benefit;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", benefit=" + benefit +
                '}';
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
