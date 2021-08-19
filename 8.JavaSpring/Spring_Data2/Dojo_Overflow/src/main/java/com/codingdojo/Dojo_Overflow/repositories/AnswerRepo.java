package com.codingdojo.Dojo_Overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Dojo_Overflow.models.Answer;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Long>{

	//dice Long por el id del user
	        List<Answer> findAll();
	       
	}

