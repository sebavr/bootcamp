package com.codingdojo.Consulta_Join.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.Consulta_Join.repo.CityRepo;
import com.codingdojo.Consulta_Join.repo.CountryRepo;
import com.codingdojo.Consulta_Join.repo.LanguageRepo;



@Service
public class ApiService {
	private final CountryRepo countryRepo;
	private final CityRepo cityRepo;
	private final LanguageRepo languageRepo;
	
	public ApiService(CountryRepo countryRepo,CityRepo cityRepo,LanguageRepo languageRepo) {
		this.countryRepo = countryRepo;
		this.cityRepo=cityRepo;
		this.languageRepo=languageRepo;
		
	}
	
	public List<Object[]> pregunta1(String language){
    	return countryRepo.buscarPaisesPorIdioma(language);
	}
    	
    	public List<Object[]> pregunta2(){
        	return countryRepo.buscarNdeCiudades();

}
    	
      	public List<Object[]> pregunta3(){
        	return cityRepo.buscarCiudadesMexico();

}
      	public List<Object[]> pregunta4(){
        	return languageRepo.buscarlenguajes();
      	}
      	
      	
      	public List<Object[]> pregunta5(){
        	return countryRepo.superficiesypoblacion();
      	}
      	
      	public List<Object[]> pregunta6(){
        	return countryRepo.monarquia();
      	}
      	
    	public List<Object[]> pregunta7(){
        	return countryRepo.distritos();
      	}
      	
}
    	
    	
    	
    	

