package com.springboot.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private ControllerService controllerService;
	
	@RequestMapping(value="/message")
	public String getMessage() {
		return "hi there ";
	}
	
	@RequestMapping(value="/persons",method=RequestMethod.GET)
	public List<Person> getPerson(){
		return controllerService.getAllPerson();
	}
	
	@RequestMapping(value="/persons/{id}")
	public Person getPersonByid(@PathVariable int id) {
		return controllerService.getPerson(id);
	}
	
	@RequestMapping(value="/persons/update", method=RequestMethod.PUT )
	public void updatePerson(@RequestBody Person person) {
		controllerService.updatePerson(person);
	}
	
	@RequestMapping(value="/persons/delete/{id}",method=RequestMethod.DELETE)
	public void deletePerson(@PathVariable int id) {
		 controllerService.deletePerson(id);
	}
	

}
