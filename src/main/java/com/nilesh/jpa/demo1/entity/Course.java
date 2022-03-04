package com.nilesh.jpa.demo1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name="find_all_courses", query="select p from Course p")
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	protected Course() {
	}
	
	public Course(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\n \n Course [id=" + id + ", name=" + name + "]";
	}
	
	
}
