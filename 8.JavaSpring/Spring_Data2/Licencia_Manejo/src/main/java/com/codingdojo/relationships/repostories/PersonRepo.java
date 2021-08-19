package com.codingdojo.relationships.repostories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.relationships.models.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long>{

	//dice Long por el id del user
	        List<Person> findAll();
	}
