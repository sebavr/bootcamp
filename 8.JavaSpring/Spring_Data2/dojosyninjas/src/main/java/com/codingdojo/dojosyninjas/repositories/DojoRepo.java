package com.codingdojo.dojosyninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojosyninjas.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long>{

	//dice Long por el id del user
	        List<Dojo> findAll();
	}
