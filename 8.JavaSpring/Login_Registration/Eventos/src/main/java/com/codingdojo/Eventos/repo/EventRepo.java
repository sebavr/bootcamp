package com.codingdojo.Eventos.repo;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.Eventos.models.Event;

public interface EventRepo extends CrudRepository<Event, Long> {

}