package com.vn.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.demo.model.Category;
import com.vn.demo.model.Product;

@Repository
public interface ShopDetailRepository extends JpaRepository<Product, Integer> {
 
	public List<Product> findById(Category categoryId);
}
