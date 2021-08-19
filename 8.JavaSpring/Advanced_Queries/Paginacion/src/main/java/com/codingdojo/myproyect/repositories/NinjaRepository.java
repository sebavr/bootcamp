package com.codingdojo.myproyect.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.myproyect.models.Ninja;


@Repository
public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long>{
    List<Ninja> findAll();
    
    @Query("SELECT n, d "
    		+ "FROM Ninja n INNER JOIN n.dojo d")
    public Page<Object[]> allNinjasDojos(PageRequest pageRequest); 
}