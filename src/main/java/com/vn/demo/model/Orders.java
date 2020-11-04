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

import lombok.Data;

@Entity
@Table(name = "Orders")
@Data
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OrdersID")
	private Integer id;
	
	@Column(name="Date")
	private Date createDate;
	
	@Column(name="Status")
	private boolean Status;
	
	@ManyToOne
	@JoinColumn(name="CustomerId")
	private Customer idCustomer;
	
}
