package com.codingdojo.dojosyninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosyninjas.models.Ninja;
import com.codingdojo.dojosyninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepo ninjaRepo;

	public NinjaService(NinjaRepo ninjaRepo) {
	
		this.ninjaRepo = ninjaRepo;
	}
	
	//devolviendo todas las canciones
    public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }
    
    //Creando una cancion
    public Ninja createNinja(Ninja s) {
        return ninjaRepo.save(s);
    }
    
  //Obteniendo la información de una cancion
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
 //eliminar una cancion
    
    public void deleteNinja(Long id) {
    	ninjaRepo.deleteById(id);
    }
    //actualizar una cancion
    public Ninja updateLanguage(Ninja song) {
		return ninjaRepo.save(song);
		
	}
    
   
    

    
    
    
}