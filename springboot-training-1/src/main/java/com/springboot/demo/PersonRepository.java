package com.springboot.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

	List<Person> findByIdLessThan(int id);
	List<Person> findByIdGreaterThan(int id);
	
	@Query(value="select * from employees where ", nativeQuery=true)
	List<Person> findAll(String name);
	
	@Query(value="select * from employees where employees.tech= :n order by name desc", nativeQuery=true)
	List<Person> findbyTechSorted(@Param("n") String tech);
	
	@Query(value="select * from employees where employees.tech= :n and employees.name= :name ", nativeQuery=true)
	List<Person> findbyName(@Param("n") String tech,String name);
	
	
	//List<Person> findByTech(String tech);
		

}
