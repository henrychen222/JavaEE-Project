package com.yz.domain;

public class CartItem {
	private Product product;
	private int quantity;
	private double price;
	public Product getProduct() {
		return product;
	} 
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.price = this.product.getPrice()*this.quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
