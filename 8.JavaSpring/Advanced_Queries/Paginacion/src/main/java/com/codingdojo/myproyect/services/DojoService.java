package com.codingdojo.myproyect.services;

    
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.myproyect.models.Dojo;
import com.codingdojo.myproyect.repositories.DojoRepository;

@Service
public class DojoService {

    private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
	public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
	public void deleteDojo(Long id) {
    	Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
        	dojoRepository.deleteById(id);
        } else {
            return;
        }
    }
	/*public Dojo updateDojo(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Dojo dojo;
    	Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            dojo=optionalDojo.get();
        } else {
            return null;
        }
    	dojo.setTitle(title);
    	dojo.setDescription(desc);
    	dojo.setLanguage(lang);
    	dojo.setNumberOfPages(numOfPages);
    	dojoRepository.save(dojo);
    	return dojo;
    	
    }*/
    
}