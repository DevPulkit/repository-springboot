package com.springboot.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ControllerService {
	
	 List<Person> list=new ArrayList<>();
	 
	
	public ControllerService() {
		System.out.println("it is the service layer ");
		list.add(new Person(1,"person1"));
		list.add(new Person(2,"person2"));
		list.add(new Person(3,"person3"));
		
	}
	
	public List<Person> getAllPerson(){
		return list;
	}
	
	public Person getPerson(int id) {
		
		for(Person p: list) {
			if(p.getId()==id) {
				return p;
			}
			 
				
			
		}
		return new Person();
		
		
	}
	public void savePerson(Person person) {
		
		this.list.add(person);
	}
	public void updatePerson(Person person) {
		
		for(Person p:list) {
			if(p.getId()==person.getId()) {
				p.setName(person.getName());
			}
		}
	}
	public void deletePerson(int id) {
		
		list.remove(id);
		
	}

}
