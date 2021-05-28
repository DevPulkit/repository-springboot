package com.springboot.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(value="/addPerson", method=RequestMethod.POST)
	public void addPerson(@RequestBody Person person) {
		
		personRepository.save(person);
	}
	
	@RequestMapping(value="/getPersons")
	public List<Person> getPersons(){
		List<Person> person=new ArrayList<>();
		personRepository.findAll().forEach(person::add);
		return person;
		
	}
	
	@RequestMapping(value="/getPerson/{id}")
	public Person getPerson(@PathVariable int id) {
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
	}
	
	
	@RequestMapping(value="/updatePerson", method=RequestMethod.POST)
	public void updatePerson(@RequestBody Person person) {
		personRepository.save(person);
		
	}
	
	@RequestMapping(value="/deletePerson/{id}",method=RequestMethod.DELETE)
	public void deletePerson(@PathVariable int id) {
		personRepository.deleteById(id);
	}
	
	@RequestMapping(value="/greater/{id}",method=RequestMethod.GET)
	public void greater(@PathVariable int id) {
		System.out.println(personRepository.findByIdLessThan(id));
		System.out.println(personRepository.findByIdGreaterThan(id));
		
	}
	
//	@RequestMapping(value="/getPersonByTech/{tech}",method=RequestMethod.GET)
//	public List<Person> techSorted(@PathVariable String tech) {
//			return personRepository.findByTech1(tech);
//		//return personRepository.findByTech(tech);
//		
//	}
	
//	@RequestMapping(value="/getmePersons")
//	public List<Person> findBySortedTech() {
//		System.out.println(personRepository.findAll());
//		return personRepository.findAll();
//		
//	}
	
	@RequestMapping(value="/getmetech/{tech}")
	public List<Person> findbytechnology(@PathVariable String tech) {
		
		return personRepository.findbyTechSorted(tech);
		
	}
	
	@RequestMapping(value="/getmename/{tech}/{name}")
	public List<Person> findbyName(@PathVariable String tech, @PathVariable String name) {
		
		return personRepository.findbyName(tech, name);
		
	}
	
		
	
	
	
	

}
