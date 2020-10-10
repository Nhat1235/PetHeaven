package com.vn.demo.model;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.sun.istack.NotNull;



@Entity
@Table(name = "CATEGORY")
public class Category {
	// annotation id dùng để hiển thị khóa chính
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// annotation notnull dùng để check xem trường name có trống không
	@NotNull
	// annotation min cho phép validate số kí tự tối thiểu
	@Min(1)
	@Column(name="name")
	private String name;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Category")
    Collection<ReadingInfo> readinginfo;
	
    
	
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

	public Category() {
		super();
	}

}
