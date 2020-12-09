package com.javainuse.model;

import java.util.ArrayList;

public class Product {

	private String type;
	private String name;
	private ArrayList<ProductCategory> categories = new ArrayList<>();
	private ArrayList<ProductGroup> groups = new ArrayList<>();
	private Double price;

	public Product() {
	}

	public Product(String type, String name, ArrayList<ProductCategory> categories, ArrayList<ProductGroup> groups, Double price) {
		this.type = type;
		this.name = name;
		this.categories = categories;
		this.groups = groups;
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

	public ArrayList<ProductCategory> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<ProductCategory> categories) {
		this.categories = categories;
	}

	public ArrayList<ProductGroup> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<ProductGroup> groups) {
		this.groups = groups;
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
				", categories=" + categories +
				", groups=" + groups +
				", price=" + price +
				'}';
	}
}