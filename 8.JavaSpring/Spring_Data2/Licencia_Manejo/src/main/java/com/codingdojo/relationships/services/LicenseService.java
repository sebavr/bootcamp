package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repostories.LicenseRepo;



@Service
public class LicenseService {
	private final LicenseRepo licenseRepo;

	public LicenseService(LicenseRepo licenseRepo) {
	
		this.licenseRepo = licenseRepo;
	}
	
	//devolviendo todas las canciones
    public List<License> allLicenses() {
        return licenseRepo.findAll();
    }
    
    //Creando una cancion
    public License createLicense(License s) {
        return licenseRepo.save(s);
    }
    
  //Obteniendo la información de una cancion
    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepo.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }
    
 //eliminar una cancion
    
    public void deleteLicense(Long id) {
    	licenseRepo.deleteById(id);
    }
    //actualizar una cancion
    public License updateLanguage(License l) {
		return licenseRepo.save(l);
		
	}
    
 
    
    
    
}