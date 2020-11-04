package com.vn.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Product")
@Data
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="ProductID")
	private Integer id;
	
	@Column(name = "Name")
	private String productName;
	
	@Column(name = "Detail")
	private String detail;
	
	@Column(name="Price")
	private String price;
	
	@Column(name="Image")
	private String image;
	
	@Column(name="Date")
	private Date createDate;
	
	@Column(name="Status")
	private boolean Status;
	
	@ManyToOne
	@JoinColumn(name="idCategory")
	private Category CategoryId;

	
	
}
