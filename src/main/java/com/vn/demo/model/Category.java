package com.vn.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name = "Category")
@Data
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CategoryID")
	private Integer id;

	@Column(name="Name")
	private String name;
	
   @Column(name="IdParent")
   private String idParent;
   
   @Column(name="IdChild")
   private String idChild;
	
    

}
