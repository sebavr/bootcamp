package com.codingdojo.dojosyninjas.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojosyninjas.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long>{

	//dice Long por el id del user
	        List<Ninja> findAll();
	}
