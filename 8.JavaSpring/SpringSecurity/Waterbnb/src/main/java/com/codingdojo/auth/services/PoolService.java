package com.codingdojo.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.auth.models.Pool;
import com.codingdojo.auth.repositories.PoolRepository;

@Service
public class PoolService {

    private final PoolRepository poolRepository;
    
    public PoolService(PoolRepository poolRepository) {
        this.poolRepository = poolRepository;
    }

    public List<Pool> allPool() {
        return poolRepository.findAll();
    }
    public Pool findPool(Long id) {
        Optional<Pool> optionalPool = poolRepository.findById(id);
        if(optionalPool.isPresent()) {
            return optionalPool.get();
        } else {
            return null;
        }
    }
	public Pool createOrUpdatePool(Pool pool) {
        return poolRepository.save(pool);
    }
	public void deletePool(Long id) {
    	Optional<Pool> optionalPool = poolRepository.findById(id);
        if(optionalPool.isPresent()) {
        	poolRepository.deleteById(id);
        } else {
            return;
        }
    }
	public List<Pool> findByAddress(String location){
		return poolRepository.findPoolsByAddress(location);
	
	}
}