package com.vn.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.demo.model.Category;
import com.vn.demo.repositories.CategoryRepository;

@Service
public class CategoryService {
    
	@Autowired
	CategoryRepository categoryrepository;
	
	public List<Category> getCategoryList() {
		return categoryrepository.findAll();
	}

	public void saveOrUpdateCategory(Category category) {
		categoryrepository.save(category);
	}
	
	public void deleteCategory(Integer id) {
		categoryrepository.deleteById(id);
	}

	public void save(Category category) {
		categoryrepository.save(category);
		
	}
	public List<Category> getFoodName() {
		return categoryrepository.getFoodInCategory();
	}
	public List<Category> getAccessoriesName() {
		return categoryrepository.getAccessoriesInCategory();
	}
	public List<Integer> getCategoryID() {
		return categoryrepository.getCategoryId();
	}
}
