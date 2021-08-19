package com.codingdojo.Consulta_Join.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.codingdojo.Consulta_Join.models.Language;

public interface LanguageRepo extends CrudRepository<Language, Long>{
	
	List<Language> findAll();
	
	@Query("SELECT c.name,l.language,l.percentage FROM Country c JOIN c.languages l WHERE l.percentage>89  ORDER BY l.percentage DESC")
	List<Object[]> buscarlenguajes();

}