package com.springboot.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	List<Person> findByIdLessThan(int id);
	List<Person> findByIdGreaterThan(int id);
	Person findByName(String name);
	
	@Query(value="select * from employees ",nativeQuery =true)
	List<Person> findAll(String name);
	
	@Query(value="select * from employees where employees.tech= :n order by name desc", nativeQuery=true)
	List<Person> findbyTechSorted(@Param("n") String tech);
	
	@Query(value="select * from employees where employees.tech= :n and employees.name= :name ", nativeQuery=true)
	List<Person> findbyName(@Param("n") String tech,String name);
	
//	@Query(value="call get_employees()", nativeQuery=true)
//	void getTotal();
	
	@Query(value="select gettotal2()", nativeQuery=true)
	int getTotal();
	
	

//	@Query(value = "SELECT  NEW com.springboot.demo.Information(p.name, d.surname) FROM employees p LEFT JOIN details d ON p.id=d.id")
//	List<Person> getbyjoin();
		
	
	
		

}