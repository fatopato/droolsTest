package com.javainuse.model;

import java.util.Objects;

public class ProductAttribute {
    private Long id;
    private String type;
    private String value;

    public ProductAttribute() {
    }

    public ProductAttribute(Long id, String type, String value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProductAttribute{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    // TODO: Konuşuruz
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductAttribute that = (ProductAttribute) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, value);
    }
}
