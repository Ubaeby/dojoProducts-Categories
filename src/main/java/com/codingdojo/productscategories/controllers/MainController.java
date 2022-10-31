package com.codingdojo.productscategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.services.CategoryService;
import com.codingdojo.productscategories.services.ProductService;

@Controller
public class MainController {

	@Autowired
	private CategoryService categoryServ;
	@Autowired
	private ProductService productServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newProduct", productServ.allProducts());
		model.addAttribute("newCategory", categoryServ.allCategories());
		return "index.jsp";
	}
	
	// Product Page creation
	
	@GetMapping("/products/new")
	public String productPage(
			@ModelAttribute("newProduct") Product newProduct, Model model ) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProduct(
			@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		}
		productServ.addProduct(newProduct);
		return "redirect:/";
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(
			@PathVariable("id") Long id, Model model) {
		model.addAttribute("products", productServ.findById(id));
		//assigned Categories
		model.addAttribute("aCategories", categoryServ.assignedProduct(productServ.findById(id)));
		//unassigned Categories
		model.addAttribute("uCategories", categoryServ.unassignedProduct(productServ.findById(id)));
		return "productPage.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String editProduct(
			@PathVariable("id") Long id, 
			@RequestParam(value="categoryId") Long categoryId, Model model) {
		
		Product product = productServ.findById(id);
		Category category = categoryServ.findById(categoryId);
		
		product.getCategories().add(category);
		productServ.updateProduct(product);
		
		model.addAttribute("aCategories", categoryServ.assignedProduct(productServ.findById(id)));
		//unassigned Categories
		model.addAttribute("uCategories", categoryServ.unassignedProduct(productServ.findById(id)));
		
		return "redirect:/products/" + id;
	}
	
	
	// Category Creation Routes
	
	@GetMapping("/categories/new")
	public String catPage(
			@ModelAttribute("newCategory") Category newCat, Model model) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String addCategory(
			@Valid @ModelAttribute("newCategory") Category newCat, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory.jsp";
		}
		categoryServ.addCategory(newCat);
		return "redirect:/";
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(
			@PathVariable("id") Long id, Model model) {
		model.addAttribute("categories", categoryServ.findById(id));
		//assigned Categories
		model.addAttribute("aProducts", productServ.assignedCategory(categoryServ.findById(id)));  
		//unassigned Categories	
		model.addAttribute("uProducts", productServ.unassignedCateogry(categoryServ.findById(id)));
		return "categoryPage.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String editCategory(
			@PathVariable("id") Long id, 
			@RequestParam(value="productId") Long productId, Model model ) {
		
		Product product = productServ.findById(productId);
		Category category = categoryServ.findById(id);
		
		category.getProducts().add(product);
		categoryServ.updateCategory(category);
		
		model.addAttribute("aProducts", productServ.assignedCategory(categoryServ.findById(id)));  
		//unassigned Categories	
		model.addAttribute("uProducts", productServ.unassignedCateogry(categoryServ.findById(id)));
		
		return "redirect:/categories/" + id;
	}
}
