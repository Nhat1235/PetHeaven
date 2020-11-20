package com.vn.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")

public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="ProductID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DETAIL")
	private String detail;
	
	@Column(name="PRICE")
	private String price;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="DATE")
	private Date createDate;
	
	@Column(name="STATUS")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="IDCATEGORY")
	private Category categoryId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPrice() {
		String parts[] = price.split("\\.");
		String part1 = parts[0];
		return part1;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	
	
}
