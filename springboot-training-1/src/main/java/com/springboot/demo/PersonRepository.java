package com.springboot.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

	List<Person> findByIdLessThan(int id);
	List<Person> findByIdGreaterThan(int id);
	
	

}
