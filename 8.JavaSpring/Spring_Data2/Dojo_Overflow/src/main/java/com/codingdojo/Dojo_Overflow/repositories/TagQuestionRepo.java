package com.codingdojo.Dojo_Overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Dojo_Overflow.models.TagQuestion;

@Repository
public interface TagQuestionRepo extends CrudRepository<TagQuestion, Long>{

	//dice Long por el id del user
	        List<TagQuestion> findAll();
	        
	}

