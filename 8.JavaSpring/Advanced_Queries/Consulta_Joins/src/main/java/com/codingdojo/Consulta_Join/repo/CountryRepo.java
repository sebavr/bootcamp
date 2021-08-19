package com.codingdojo.Consulta_Join.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Consulta_Join.models.Country;



@Repository
public interface CountryRepo extends CrudRepository<Country, Long>{
	
	List<Country> findAll();
	
	@Query("SELECT c.name,l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = ?1 ORDER BY l.percentage desc")
	List<Object[]> buscarPaisesPorIdioma(String language);
	
	@Query("SELECT c.name,count(DISTINCT d.name) FROM Country c JOIN c.cities d GROUP BY c.name ORDER BY count(DISTINCT d.name) desc ")
	List<Object[]> buscarNdeCiudades();
	
	
	@Query("SELECT c.name,c.surface_area, c.population FROM Country c WHERE c.surface_area<501 AND c.population>100000")
	List<Object[]> superficiesypoblacion();
	
	@Query("SELECT c.name,c.government_form,c.surface_area,c.life_expectancy FROM Country c WHERE c.government_form = 'Constitutional Monarchy' AND c.life_expectancy > 75 AND c.surface_area > 200 ")
	List<Object[]> monarquia();
	
	
	@Query("SELECT c.name,cs.name,cs.district,c.population FROM Country c JOIN c.cities cs WHERE c.name='Argentina' AND cs.district='Buenos Aires' AND  c.population>500000")
	List<Object[]> distritos();


}
