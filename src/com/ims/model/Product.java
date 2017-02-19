package com.ims.model;

import java.io.Serializable;


public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer productId;
	
	private String productName;

	private Integer level;
	
	private String location;
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", level=" + level + ", location=" + location
				+ "]";
	}
	
}
