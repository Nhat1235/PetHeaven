package com.vn.demo.DTO;

public class PaginateDTO {
	private Integer currentPage;
	private Integer limit;
	private Integer start;
	private Integer end;
	private Integer totalPage;

	public PaginateDTO(Integer currentPage, Integer limit, Integer start, Integer end, Integer totalPage) {
		super();
	}

	public PaginateDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

}
