package com.codingdojo.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;

@Repository
public interface CategoryRepository  extends CrudRepository<Category, Long>{

	List<Category> findAll();
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
	Category findByIdIs(Long id);
}
