package com.codingdojo.Lookify.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.Lookify.Repo.LookifyRepo;
import com.codingdojo.Lookify.models.Song;



@Service
public class LookifyService {
	private final LookifyRepo lookifyRepo;

	public LookifyService(LookifyRepo lookifyRepo) {
	
		this.lookifyRepo = lookifyRepo;
	}
	
	//devolviendo todas las canciones
    public List<Song> allSongs() {
        return lookifyRepo.findAll();
    }
    
    //Creando una cancion
    public Song createSong(Song s) {
        return lookifyRepo.save(s);
    }
    
  //Obteniendo la información de una cancion
    public Song findSong(Long id) {
        Optional<Song> optionalLookify = lookifyRepo.findById(id);
        if(optionalLookify.isPresent()) {
            return optionalLookify.get();
        } else {
            return null;
        }
    }
    
 //eliminar una cancion
    
    public void deleteSong(Long id) {
    	lookifyRepo.deleteById(id);
    }
    //actualizar una cancion
    public Song updateLanguage(Song song) {
		return lookifyRepo.save(song);
		
	}
    
    public List<Song> getTopTen() {
		return lookifyRepo.findTop10ByOrderByRateDesc();
	}
    
  public List<Song> findbyArtist(String name){
		return lookifyRepo.findByArtist(name);
	}
    
    
    
}
