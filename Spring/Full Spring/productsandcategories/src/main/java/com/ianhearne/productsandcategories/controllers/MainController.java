package com.ianhearne.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ianhearne.productsandcategories.models.Category;
import com.ianhearne.productsandcategories.models.Product;
import com.ianhearne.productsandcategories.services.CategoryService;
import com.ianhearne.productsandcategories.services.ProductService;

@Controller
public class MainController {
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	////	GET MAPS    ////
	
	@GetMapping("/")
	public String homepage(Model model) {
		model.addAttribute("productList", productService.getAll());
		model.addAttribute("categoryList", categoryService.getAll());
		return "homepage.jsp";
	}
	
	@GetMapping("/products/new")
	public String createProduct(@ModelAttribute("newProduct") Product newProduct) {
		return "add-product.jsp";
	}
	
	@GetMapping("/products/{productId}")
	public String showProduct(@PathVariable Long productId, Model model) {
		Product product = productService.findById(productId);
		
		model.addAttribute("product", product);
		model.addAttribute("categoryList", categoryService.getCategoriesNotInProduct(product));
		
		return "show-product.jsp";
	}
	
	@GetMapping("/categories/new")
	public String createCategory(@ModelAttribute("newCategory") Category newCategory) {
		return "add-category.jsp";
	}
	
	//// POST MAPS    ////
	
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result) {
		if(result.hasErrors()) {
			return "add-product.jsp";
		}
		productService.create(newProduct);
		return "redirect:/";
	}
	
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result) {
		if(result.hasErrors()) {
			return "add-category.jsp";
		}
		categoryService.create(newCategory);
		return "redirect:/";
		
	}
	
	@PostMapping("/products/add-category")
	public String addCategoryToProduct(@RequestParam("categories") Category category, @RequestParam("product-id") Long id) {
		Product product = productService.findById(id);
		productService.addCategoryToProduct(product, category);
		return "redirect:/products/" + product.getId();
	}
}
