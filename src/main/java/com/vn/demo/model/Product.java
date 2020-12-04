package com.vn.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ProductID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DETAIL")
	private String detail;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name = "IMAGE1")
	private String image1;
	
	@Column(name = "IMAGE2")
	private String image2;
	
	
	@Column(name="DATE")
	private Date createDate;
	
	@Column(name="STATUS")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="IDCATEGORY")
	private Category categoryId;

	

	public Product() {
		super();
	}

	public Product(Integer id, String name, String detail, double price, String image, String image1, String image2,
			Date createDate, boolean status, Category categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.image = image;
		this.image1 = image1;
		this.image2 = image2;
		this.createDate = createDate;
		this.status = status;
		this.categoryId = categoryId;
	}

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

	public double getPrice() {
		
	    return price;
	}

	public void setPrice(double price) {
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", detail=" + detail + ", price=" + price + ", image=" + image
				+ ", image1=" + image1 + ", image2=" + image2 + ", createDate=" + createDate + ", status=" + status
				+ ", categoryId=" + categoryId + "]";
	}

	
	
}
