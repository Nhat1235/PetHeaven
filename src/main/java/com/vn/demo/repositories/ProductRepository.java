package com.vn.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vn.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
