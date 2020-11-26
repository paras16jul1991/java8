package com.crisil.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Product {
	private String name;
	public int price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "name : " + name + " price : " + price;
	}
}

public class ProductDetails {

	List<Product> getDiscountedProductDetails(int price, List<Product> products) {

		Map<Integer, Product> map = new HashMap<Integer, Product>();
		List<Product> list = new ArrayList<Product>();

		for (Product product : products) {
			boolean flag = map.get(price - product.price) != null ? true : false;
			if (flag) {
				list.add(map.get(price - product.price));
				list.add(product);
				break;
			} else
				map.put(product.price, product);
		}

		return list;

	}

	public static void main(String[] args) {
		ProductDetails details = new ProductDetails();
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("X", 40));
		products.add(new Product("Y", 30));
		products.add(new Product("Z", 20));
		products.add(new Product("A", 70));
		products.add(new Product("B", 60));

		System.out.print(details.getDiscountedProductDetails(100, products));
	}

}
