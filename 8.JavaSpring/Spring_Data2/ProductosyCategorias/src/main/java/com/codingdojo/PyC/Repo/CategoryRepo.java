package com.codingdojo.PyC.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.PyC.Models.Category;
import com.codingdojo.PyC.Models.Product;



public interface CategoryRepo extends CrudRepository<Category, Long>{

	//dice Long por el id del user
	        List<Category> findAll();
	        List<Category> findByProductsNotContains(Product product);
	        
	}