package com.luxmart.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.luxmart.model.Person;

import reactor.core.publisher.Mono;

@Repository("personRepository")
public interface PersonReactiveRepository extends ReactiveMongoRepository<Person, String>{
	
	// find person by lastName
	Mono<Person> findByLastName(String lastName);

}
