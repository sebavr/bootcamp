package com.codingdojo.Lookify.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Lookify.models.Song;




@Repository
public interface LookifyRepo extends CrudRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findTop10ByOrderByRateDesc();
	List<Song> findByArtist(String artist);
	

}
