package com.vn.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity // Đánh dấu đây là table trong db
@Table(name = "Customer")
@Data
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CustomerID")
	private Integer id;
    
	@Column(name="IMAGE")
	private String anh;
	
	@Column(name="ADRESS")
	private String diachi;
	
	@Column(name="PHONE")
	private String SDT;
	
	@Column(name="EMAIL")
	private String email;

	public Customer() {
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
	


}
