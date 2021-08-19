package com.codingdojo.Consulta_Join.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.Consulta_Join.models.City;



public interface CityRepo extends CrudRepository<City, Long>{

	//dice Long por el id del user
List<City> findAll();

@Query("SELECT cc.name FROM City cc JOIN cc.country c WHERE c.name='Mexico' AND c.population>500000 ORDER BY c.population DESC")
List<Object[]> buscarCiudadesMexico();
}
