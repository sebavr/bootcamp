package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repostories.LicenseRepo;
import com.codingdojo.relationships.repostories.PersonRepo;

@Service
public class PersonService {
	private final PersonRepo personRepo;
	private final LicenseRepo licenseRepo;
	public static int licenseNumber;

	public PersonService(PersonRepo personRepo,LicenseRepo licenseRepo) {
	
		this.personRepo = personRepo;
		this.licenseRepo=licenseRepo;
	}
	
	public static int getLicenseNumber() {
		return licenseNumber;
	}

	public static void setLicenseNumber(int licenseNumber) {
		PersonService.licenseNumber = licenseNumber;
	}

	public PersonRepo getPersonRepo() {
		return personRepo;
	}

	public LicenseRepo getLicenseRepo() {
		return licenseRepo;
	}

	//devolviendo todas las persons
    public List<Person> allPersons() {
        return personRepo.findAll();
    }
    
    //Creando nueva person
    public Person createPerson(Person s) {
        return personRepo.save(s);
    }
    
   // creando nueva license
    
    public License createLicense(License s) {
        return licenseRepo.save(s);
    }
    
    
    public String stringLicenseNumber(int num) {
		String format = String.format("%06d", num);
		return format;
	}
    
    
    public String generateLicenseNumber() {
		if(licenseRepo.findTopByOrderByNumberDesc().isEmpty()) {
			licenseNumber +=1;
			return stringLicenseNumber(licenseNumber); 
		}
		else {
			List<License> t = licenseRepo.findTopByOrderByNumberDesc();
			licenseNumber = 1+(Integer.parseInt(t.get(0).getNumber()));
			return stringLicenseNumber(licenseNumber); 
		}
		
	}
    
	
    
    
    
    
    
  //Obteniendo la información de una cancion
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepo.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
    
 //eliminar una cancion
    
    public void deletePerson(Long id) {
    	personRepo.deleteById(id);
    }
    //actualizar una cancion
    public Person updatePerson(Person p) {
		return personRepo.save(p);
		
	}
    
    
    public void deleteLicense(Long id) {
    	licenseRepo.deleteById(id);
    }
    //actualizar una cancion
    public License updateLicense(License l) {
		return licenseRepo.save(l);
		
	}
    public Optional<License> getLicense(Long id) {
		return licenseRepo.findById(id);
	}
    
    
    
}