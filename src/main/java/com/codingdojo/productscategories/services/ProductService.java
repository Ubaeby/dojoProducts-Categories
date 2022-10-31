package com.codingdojo.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public List<Product> assignedCategory(Category c) {
		return productRepo.findAllByCategories(c);
	}
	
	public List<Product> unassignedCateogry(Category c) {
		return productRepo.findByCategoriesNotContains(c);
	}
	
	public Product findById(Long id) {
		Optional<Product> optionalP = productRepo.findById(id);
		if (optionalP.isPresent()) {
			return optionalP.get();
		}
		
		return null;
	}
	
	public Product addProduct(Product p) {
		return productRepo.save(p);
	}
	
	public Product updateProduct(Product p) {
		return productRepo.save(p);
	}
	
	
//	public Product addProduct(Product p) {
//		Category thisCategory = findCategoryById(categoryId);
//		Product thisProduct = findProductById(p.getId());
//		
//		thisProduct.getCategories().add(thisCategory);
//		productRepo.save(thisProduct);
//		
//	}
	

}
