package com.springboot.demo;

public class Information {
	
	private String name;
	private String surname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Information(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	public Information() {
		
	}
	
	@Override
	public String toString() {
		return "Information [name=" + name + ", surname=" + surname + "]";
	}
	
	
	
	

}
