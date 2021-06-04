package com.springboot.demo;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Person  {
	
	@Id 
	private int id;
	private String name;
	private String tech;
	private String password;
	private String role;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Person() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", tech=" + tech + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	

}
