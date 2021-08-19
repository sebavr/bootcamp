package com.codingdojo.relationships.repostories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long>{

	//dice Long por el id del user
	        List<License> findAll();

			List<License> findTopByOrderByNumberDesc();
	}