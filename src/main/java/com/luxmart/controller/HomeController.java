package com.luxmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.luxmart.model.Person;
import com.luxmart.repository.PersonReactiveRepository;

@RestController
public class HomeController {
	@Autowired
	PersonReactiveRepository personRepository;

	// return the list of records
	@RequestMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public List<Person> getPersons() {
		return personRepository.findAll().collectList().block();
	}

	// get a record by id
	@RequestMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Person getPersonById(@PathVariable("id") String id) {

		return personRepository.findById(id).block();

	}

	// add a new record to DB
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Person add(@RequestBody Person person) {

		// return the newlyCreated record
		return personRepository.save(person).block();
	}

	// update a record on the DB
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Person update(@RequestBody Person person) {

		return personRepository.save(person).block();

	}

	// delete a record form DB
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String delete(@PathVariable("id") String id) {
		// check if the person exist
		Person person = personRepository.findById(id).block();

		// check if the class is null or empty
		if (person == null) {
			// no record found
			return "This record " + id + " does not exist on our resources";
		} else {
			// delete the record from Db
			personRepository.deleteById(id).block();
			return "This Person has been delete from the records " + person.fullName();
		}

	}

}
