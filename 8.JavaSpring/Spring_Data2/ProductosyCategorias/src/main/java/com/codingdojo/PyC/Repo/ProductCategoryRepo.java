package com.codingdojo.PyC.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.codingdojo.PyC.Models.ProductCategory;


public interface ProductCategoryRepo extends CrudRepository<ProductCategory, Long>{

	//dice Long por el id del user
	       
	   
	}