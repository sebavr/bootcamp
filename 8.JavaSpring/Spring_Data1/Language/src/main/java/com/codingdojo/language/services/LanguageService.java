package com.codingdojo.language.services;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Service;

import com.codingdojo.language.models.Language;
import com.codingdojo.language.repositories.LanguageRepository;


@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository=languageRepository;
	}
	//Devolviendo todos los languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    //Creando un language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    

    
  //Obteniendo la información de un language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
   //eliminar un language
    
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
    
    
    
    //actualizar
    
   /*public Language updateLanguage(Long id,String name, String creator, String version) {
    	Language l=new Language();
    	
    	
    	return languageRepository.save(l);
		
	}*/
	public Language updateLanguage(Language language) {
		return languageRepository.save(language);
		
	}

	
}