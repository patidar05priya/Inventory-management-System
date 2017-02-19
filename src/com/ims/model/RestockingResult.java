package com.ims.model;

public class RestockingResult {

	private Product product;
	
	private String msg;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "RestockingResult [product=" + product + ", msg=" + msg + "]";
	}
	
	
	
}
