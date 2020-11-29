package com.vn.demo.DTO;

import org.springframework.stereotype.Service;

@Service
public interface Paginate {
   
	public PaginateDTO getInfoPaginate(Integer totalPage, Integer currentPage, Integer limit);
	
}
