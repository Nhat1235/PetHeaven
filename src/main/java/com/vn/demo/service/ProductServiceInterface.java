package com.vn.demo.service;

import java.util.List;

import com.vn.demo.model.Product;

public interface ProductServiceInterface {

	List<Product> getAll();

	Product findById(int id);

	Product findByName(String name);

}
