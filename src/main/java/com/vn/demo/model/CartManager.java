package com.vn.demo.model;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class CartManager {
	//khai bao key session
	private static final String SESSION_KEY_SHOPPING_CART="giohang";
	// lay ve gio hang
	public Cart getCart(HttpSession session) {
		//lay ve gio hang theo session
		Cart cart = (Cart) session.getAttribute(SESSION_KEY_SHOPPING_CART);
		//neu da ton tai gio hang
		if(cart==null) {
			cart = new Cart(); //tao moi gio hangf
			setCart(session, cart);//thiet lap gio hang
		}
		return cart;
	}
	//ham thiet lap gio hang
	public void setCart(HttpSession session, Cart cart) {
		session.setAttribute(SESSION_KEY_SHOPPING_CART, cart);
	}
	//ham xoa gio hang
	public void removeCart(HttpSession session) {
		session.removeAttribute(SESSION_KEY_SHOPPING_CART);
	}
}
