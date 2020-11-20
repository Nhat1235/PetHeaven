package com.vn.demo.repositories;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vn.demo.model.Category;
import com.vn.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	/*
	 * @Query(value="select * from product where categoryid =:categoryId",countQuery
	 * = "select count(*) from product where categoryid =:categoryId",nativeQuery =
	 * true) public Page<Product> findProductwithCategoryId(@Param("categoryId")
	 * Integer categoryId,Pageable pageable);
	 */
	
	
	public List<Product> findByCategoryId(Category categoryId);

//	@Query(countQuery = "select top(*) from product where categoryId := id",nativeQuery = true)
//	 public Page<Product> findByCategoryById(Category id, Pageable pageable); 
	 
	 
	 
}
