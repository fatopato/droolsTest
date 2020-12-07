package com.javainuse.model;

public class Product {

	private String type;
	private String name;
	private ProductCategory category;
	private Double price;

	public Product() {
	}

	public Product(String type, String name, ProductCategory category, Double price) {
		this.type = type;
		this.name = name;
		this.category = category;
		this.price = price;
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

	@Override
	public String toString() {
		return "Product{" +
				"type='" + type + '\'' +
				", name='" + name + '\'' +
				", category=" + category +
				", price=" + price +
				'}';
	}
}