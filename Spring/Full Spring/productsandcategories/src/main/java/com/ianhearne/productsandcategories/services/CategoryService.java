package com.ianhearne.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ianhearne.productsandcategories.models.Category;
import com.ianhearne.productsandcategories.models.Product;
import com.ianhearne.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepo;
	
	public Category create(Category newCategory) {
		return categoryRepo.save(newCategory);
	}
	
	public List<Category> getAll() {
		return categoryRepo.findAll();
	}
	
	public List<Category> getProductCategories(Product product) {
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> getCategoriesNotInProduct(Product product) {
		List<Category> list =  categoryRepo.findByProductsNotContains(product);
		return list;
	}
}
