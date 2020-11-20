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
	
	@Column(name = "parentname")
	private String parentname;
	
	@Column(name="categoryname")
	private String categoryname;
	

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}


	
	
}
