package com.vn.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.vn.demo.model.Product;

public class Cart {
//quan ly sp va sl sp
	private final List<CartItem> items;//san pham
	private float total;
	public Cart() {
		items = new ArrayList<CartItem>();// khoi tao cac item
		total=0;
	}
	//ham lay ve item
	public CartItem getItem(Product p) {
		for (CartItem item : items) {
			if(item.getProduct().getId()==p.getId()) {// đã tồn tại số luongj trong gio hang
				return item;
			}
		}
		return null;// k 
	}
	//lay ve tat ca item item
	public List<CartItem> getItems(){
		return items;
	}
	//lay  so luong item
	public int getItemCount() {
		return items.size();
	}
	//them 1 sp
	public void addItem(CartItem item) {
		addItem(item.getProduct(),item.getQuantity());
	}
	// them item voi so luong cho truoc
	public void addItem(Product p, int quantity) {
		CartItem item = getItem(p);
		if(item!=null) {
			item.setQuantity(item.getQuantity()+quantity);// so luong cu+ so luong moi
		}else {// nếu chưa có item
			item = new CartItem(p); //tao 1 sp moi
			item.setQuantity(quantity);// set so luong sl
			items.add(item);// them vao danh sach item
		}
	}
	//sua sp
	public void updateItem(Product p , int quantity) {
		CartItem item = getItem(p);// lay ve san pham can update
		if(item!=null) {
			item.setQuantity(quantity);
		}
		
	}
	//xoa sp
	public void removeItem(Product p) {
		CartItem item = getItem(p);// lay danh sach san pham
		if(item!=null) {
			items.remove(item);// xoa	
		}
	}
	//xoa tat ca sp
	public void clear() {
		items.clear();
		total=0;
	}
	//kiem tra gio hang co trong hay k
	public boolean isEmpty() {
		return items.isEmpty();
	}
	// lay ve tong tien
	public double getTotal() {
		total = 0;
		for (CartItem item : items) {
			/* total += item.getSubTotal(); */
		}
		return total;
	}
}
