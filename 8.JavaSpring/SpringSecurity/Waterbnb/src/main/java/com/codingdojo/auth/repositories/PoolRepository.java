package com.codingdojo.auth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.auth.models.Pool;

@Repository
public interface PoolRepository extends CrudRepository<Pool, Long>{
    List<Pool> findAll();
    @Query("SELECT p FROM Pool p WHERE p.address like %?1%")
    List<Pool> findPoolsByAddress(String location);
}