package com.vn.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

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
	
	@Column(name = "IMAGE1")
	private String image1;
	
	@Column(name = "IMAGE2")
	private String image2;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="DATE")
	private Date createDate;
	
	@Column(name="STATUS")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="IDCATEGORY")
	private Category categoryId;

	

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

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
	return price;
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
