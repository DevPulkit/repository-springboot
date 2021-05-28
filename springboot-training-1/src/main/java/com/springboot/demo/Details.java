package com.springboot.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="details")
public class Details {
	
	@Id
	private int id;
	
	private String surname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Details(int id, String surname) {
		super();
		this.id = id;
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		return "Details [id=" + id + ", surname=" + surname + "]";
	}
	
	

}
