package com.wpc.model;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 2149183579L;

	private String productName;
	private String description;
	private double price;

	public Product() {
	}

	public Product(String productName, String description, double price) {
		this.productName = productName;
		this.description = description;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
