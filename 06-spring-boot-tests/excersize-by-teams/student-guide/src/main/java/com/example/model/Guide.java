package com.example.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Guide {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;	
	
	private String name;
	
	private Integer salary;
	
	@OneToMany(mappedBy="guide", cascade={CascadeType.PERSIST})
	private Set<Student> students = new HashSet<Student>();	
	
	public Guide() {}
	public Guide(String name, Integer salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public Set<Student> getStudents() {
		return students;
	}	
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public void addStudent(Student student) {
		students.add(student);
		student.setGuide(this);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return name;
	}
	
	
	
}	







