package com.springboot.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ControllerService {
	
	private PersonRepository personRepository;
	
	public List<Person> getAllPersons(){
		List<Person> persons=new ArrayList<>();
		personRepository.findAll().forEach(person->persons.add(person));
		return persons;
	}
	
	public Person getPersonById(int id) {
		return personRepository.findById(id).get();
	}
	
	public void saveOrUpdate(Person person) {
		personRepository.save(person);
	}
	
	
	public void delete(int id) {
		personRepository.deleteById(id);
	}
	
	
 

	}
	
