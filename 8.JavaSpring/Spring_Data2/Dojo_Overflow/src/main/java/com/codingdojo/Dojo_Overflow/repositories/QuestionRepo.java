package com.codingdojo.Dojo_Overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Dojo_Overflow.models.Question;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long>{

	//dice Long por el id del user
	        List<Question> findAll();
	
	}

