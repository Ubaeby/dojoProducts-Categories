package com.codingdojo.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	
	public List<Category> assignedProduct(Product p) {
		return categoryRepo.findAllByProducts(p);
	}
	
	public List<Category> unassignedProduct(Product p) {
		return categoryRepo.findByProductsNotContains(p);
	}
	
	public Category findById(Long id) {
		Optional<Category> optionalC = categoryRepo.findById(id);
		if(optionalC.isPresent()) {
			return optionalC.get();
		}
		
		return null;
	}
	
	public Category addCategory(Category c) {
		return categoryRepo.save(c);
	} 
	
	public Category updateCategory(Category c) {
		return categoryRepo.save(c);
	}
}
