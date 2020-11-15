package com.vn.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryID")
    private Integer id;
	
	@Column(name="Parent")
	private String cparent;
	
	@Column(name="Child")
	private String cchild;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCparent() {
		return cparent;
	}

	public void setCparent(String cparent) {
		this.cparent = cparent;
	}

	public String getCchild() {
		return cchild;
	}

	public void setCchild(String cchild) {
		this.cchild = cchild;
	}
	
	
}
