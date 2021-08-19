package com.codingdojo.PyC.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.PyC.Models.Category;
import com.codingdojo.PyC.Models.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{

	//dice Long por el id del user
	        List<Product> findAll();
	        List<Product> findByCategoriesNotContains(Category category);
	}