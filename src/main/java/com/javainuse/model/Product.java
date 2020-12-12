package com.javainuse.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private Long id;
	private String type;
	private String name;
	private ProductCategory category;
	private Double price;
	private List<ProductAttribute> attributeList = new ArrayList<>();

	public Product() {
	}

	public Product(String type, String name, ProductCategory category, Double price) {
		this.type = type;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Product(Long id, String type, String name, ProductCategory category, Double price) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Product(Long id, String type, String name, ProductCategory category, Double price, List<ProductAttribute> attributeList) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.category = category;
		this.price = price;
		this.attributeList = attributeList;
	}

	public List<ProductAttribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(List<ProductAttribute> attributeList) {
		this.attributeList = attributeList;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", type='" + type + '\'' +
				", name='" + name + '\'' +
				", category=" + category +
				", price=" + price +
				'}';
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}