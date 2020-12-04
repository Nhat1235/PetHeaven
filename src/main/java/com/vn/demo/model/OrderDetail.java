package com.vn.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OrderDetailID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ProductId")
	private Product IdProduct;
	
	@ManyToOne
	@JoinColumn(name="OrderId")
	private Orders IdOrder;

	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="totalPrice")
	private Float totalPrice;
	
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getIdProduct() {
		return IdProduct;
	}

	public void setIdProduct(Product idProduct) {
		IdProduct = idProduct;
	}

	public Orders getIdOrder() {
		return IdOrder;
	}

	public void setIdOrder(Orders idOrder) {
		IdOrder = idOrder;
	}
	
	
}
