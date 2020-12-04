package com.vn.demo.model;

public class CartItem {
	private final Product product;
	
	private int quantity;
	
	private double subTotal;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubTotal() {
		subTotal = (product.getPrice() * quantity);
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public Product getProduct() {
		return product;
	}
	
	public CartItem(Product product) {
	this.product = product;
	this.quantity = 1;// so luong	
	this.subTotal = (product.getPrice() * quantity);
	}
	
}
