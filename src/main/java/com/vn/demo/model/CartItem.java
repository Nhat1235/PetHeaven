package com.vn.demo.model;

public class CartItem {
   private final Product product ;
   
   private int quantity;
   
   private double Totalprice;

public CartItem(Product product) {
	super();
	this.product = product;
	this.quantity = 1;
	this.Totalprice = product.getPrice();
}


public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public double getTotalprice() {
	return Totalprice = product.getPrice() * quantity;
}

public void setTotalprice(double totalprice) {
	Totalprice = totalprice;
}

public Product getProduct() {
	return product;
}
   
}
