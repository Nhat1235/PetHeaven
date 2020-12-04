package com.vn.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vn.demo.model.Product;
import com.vn.demo.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	
	@Override
	public List<Product> getAll() {

		return (List<Product>) productRepository.findAll();

	}

	@Override
	public Product findById(int id) {

		Product p = productRepository.findById(id).orElse(null);

		return p;

	}

	@Override
	public Product findByName(String name) {
		
		return productRepository.getByName(name);
		
		
	}

}
