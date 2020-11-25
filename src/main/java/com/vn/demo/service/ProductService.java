package com.vn.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.demo.model.Category;
import com.vn.demo.model.Product;
import com.vn.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository; 
	
	public List<Product> getProductList() {
		return productRepository.findAll();
	}

	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}

	public void saveOrUpdateProduct(Product product) {
		productRepository.save(product);
	}
	
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}

	public void save(Product product) {
		productRepository.save(product);
	}
	public List<Category> getCategoryName(int categoryID) {
		return productRepository.getCategoryName(categoryID);
	}
}
