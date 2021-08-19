package com.codingdojo.myproyect.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.myproyect.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
    List<Dojo> findAll();

}