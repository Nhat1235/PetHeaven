package com.vn.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.demo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

//	@Query(value = "Select * from Category",nativeQuery = true)
//	public List<Category> fetchAllType();
}
