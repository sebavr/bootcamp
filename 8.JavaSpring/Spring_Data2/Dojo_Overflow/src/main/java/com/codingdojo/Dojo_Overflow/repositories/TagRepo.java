package com.codingdojo.Dojo_Overflow.repositories;





import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Dojo_Overflow.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long>{

	//dice Long por el id del user
	       
	        
//ignoreallcase significa tratar de la misma fomra a minusculas y mayusculas
	        Tag findBySubjectIgnoreCase(String subject);
	        
	}

