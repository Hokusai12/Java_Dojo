package com.ianhearne.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ianhearne.productsandcategories.models.Category;
import com.ianhearne.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	public List<Category> findAll();
	
	public List<Category> findByProductsNotContains(Product product);
	public List<Category> findAllByProducts(Product product);
}
