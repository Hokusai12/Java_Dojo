package com.ianhearne.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ianhearne.productsandcategories.models.Category;
import com.ianhearne.productsandcategories.models.Product;
import com.ianhearne.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepo;
	
	public Product create(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> getAll() {
		return productRepo.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		return null;
	}
	
	public Product addCategoryToProduct(Product product, Category category) {
		if(category == null) {
			return product;
		}
		product.getCategories().add(category);
		return productRepo.save(product);
	}
}
