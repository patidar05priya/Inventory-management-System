package com.ims.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.ims.model.Product;

public class ConfigUtil {

	private static final Logger LOGGER = Logger.getLogger(ConfigUtil.class.getName());
	
	public static List<Product> products = new ArrayList<Product>();
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	static {
		Product product0 = new Product();
		products.add(product0);
		
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("home");
		product.setLevel(1);
		product.setLocation("A-Block");
		products.add(product);
		
		Product product2 = new Product();
		product2.setProductId(2);
		product2.setProductName("office");
		product2.setLevel(2);
		product2.setLocation("B-Block");
		products.add(product2);
	}
	
	public static Integer convertToInt(String value){
		try{
			return Integer.parseInt(value);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new NumberFormatException(value+" can't be convert into integer");
		}
	}
	
}
