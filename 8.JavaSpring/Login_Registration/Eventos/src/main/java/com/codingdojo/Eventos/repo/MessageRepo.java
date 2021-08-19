package com.codingdojo.Eventos.repo;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.Eventos.models.Message;

public interface MessageRepo extends CrudRepository<Message, Long> {

}
