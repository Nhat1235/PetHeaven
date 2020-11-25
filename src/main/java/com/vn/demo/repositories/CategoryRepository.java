package com.vn.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.demo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public List<Category> findAll();
	
	@Query(value = "select distinct * from category where parentname like N'Thức ăn'",nativeQuery = true)
	public List<Category> getFoodInCategory();
	
	@Query(value = "select distinct * from category where parentname like N'Phụ kiện'",nativeQuery = true)
	public List<Category> getAccessoriesInCategory();
	
	@Query(value = "select distinct CategoryID from Category",nativeQuery = true)
	public List<Integer> getCategoryId();
}
