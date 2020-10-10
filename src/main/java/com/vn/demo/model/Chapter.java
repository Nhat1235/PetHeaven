package com.vn.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Chapters")
public class Chapter {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "CHAPTERNAME")
	private String chapterName;
	@Column(name = "CONTENT")
	private String content;

	@ManyToOne
	@JoinColumn(name="infoid")
	private ReadingInfo infoId;
	
	

	public Chapter() {
		super();
	}

	public Chapter(Integer id, String chapterName, String content, ReadingInfo infoId) {
		super();
		this.id = id;
		this.chapterName = chapterName;
		this.content = content;
		this.infoId = infoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ReadingInfo getInfoId() {
		return infoId;
	}

	public void setInfoId(ReadingInfo infoId) {
		this.infoId = infoId;
	}
	
}
