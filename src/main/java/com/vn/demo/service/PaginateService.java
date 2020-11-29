package com.vn.demo.service;

import org.springframework.stereotype.Service;

import com.vn.demo.DTO.PaginateDTO;

@Service	
public class PaginateService {

	public PaginateDTO getInfoPaginate(Integer totalData, Integer currentPage, Integer limit) {
		PaginateDTO page = new PaginateDTO();
		page.setTotalPage(SetInfoTotalPage(totalData, limit));
		page.setLimit(limit);
		page.setCurrentPage(CheckCurrentPage(currentPage,page.getTotalPage()));
		
		int start = FindStart(page.getCurrentPage(),limit);
		page.setStart(start);
		int end = FindEnd(page.getStart(),limit,totalData);
		
		return page;
	}

	private int FindEnd(Integer start, Integer limit, Integer totalData) {
		// TODO Auto-generated method stub
		return start + limit > totalData ? totalData : (start + limit) -1;
	}

	private int FindStart(Integer currentPage, Integer limit) {
		// TODO Auto-generated method stub
		return ((currentPage - 1) * limit ) + 1;
	}

	private Integer CheckCurrentPage(Integer currentPage, Integer totalPage) {
		if(currentPage < 1) {
			return 1;
		}
		if(currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}

	private Integer SetInfoTotalPage(Integer totalData, Integer limit) {
		int totalPage = 0;
		totalPage = totalData/limit;
		totalPage = totalPage * limit < totalData ? totalPage + 1: totalPage;
		return totalPage;
	}
	
}