package com.codingdojo.dojosyninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosyninjas.models.Dojo;
import com.codingdojo.dojosyninjas.repositories.DojoRepo;



@Service
public class DojoService {
	private final DojoRepo dojoRepo;

	public DojoService(DojoRepo dojoRepo) {
	
		this.dojoRepo = dojoRepo;
	}
	
	//devolviendo todas las canciones
    public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }
    
    //Creando una cancion
    public Dojo createDojo(Dojo s) {
        return dojoRepo.save(s);
    }
    
  //Obteniendo la información de una cancion
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
 //eliminar una cancion
    
    public void deleteDojo(Long id) {
    	dojoRepo.deleteById(id);
    }
    //actualizar una cancion
    public Dojo updateLanguage(Dojo song) {
		return dojoRepo.save(song);
		
	}
    
   
    

    
    
    
}