package com.codingdojo.myproyect.services;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.myproyect.models.Ninja;
import com.codingdojo.myproyect.repositories.NinjaRepository;

@Service
@Transactional
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
	public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
	public void deleteNinja(Long id) {
    	Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
        	ninjaRepository.deleteById(id);
        } else {
            return;
        }
    }

	private static final int PAGE_SIZE = 5;
	public Page<Object[]> ninjasPerPage(int pageNumber) {
		PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "lastName");
		Page<Object[]> ninjas = ninjaRepository.allNinjasDojos(pageRequest);
		return ninjaRepository.allNinjasDojos(pageRequest);
	}
    
}