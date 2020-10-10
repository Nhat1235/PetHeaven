package com.vn.demo.model;


import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "READING_INFO")
public class ReadingInfo {
	@Id
	@Column(name="IDREAD", unique = true, columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IDREAD;
	private String code;
	private String name;
	private String photo;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String information; 
	private String author;
	private Integer views;

	@ManyToOne
	@JoinColumn(name="Categoryid")
	private Category Category;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "infoId")
	Collection<Chapter> chapters;
	
	public ReadingInfo() {
		super();
	}
	public ReadingInfo(Integer IDREAD, String code, String name, String photo, Date date, String information, String author,
			Integer views, Category Category) {
		super();
		this.IDREAD = IDREAD;
		this.code = code;
		this.name = name;
		this.photo = photo;
		this.date = date;
		this.information = information;
		this.author = author;
		this.views = views;
		this.Category = Category;
	}
	public Integer getId(Integer IDREAD) {
		return IDREAD;
	}
	public void setId(Integer IDREAD) {
		this.IDREAD = IDREAD;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Category getCategory() {
		return Category;
	}
	public void setCategory(Category Category) {
		this.Category = Category;
	}
	
}
