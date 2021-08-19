package com.codingdojo.SelfJoin.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

//...
@Entity
@Table(name="employees")
public class Employee {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String firstName;
 private String lastName;
 private Date createdAt;
 private Date updatedAt;
 
 @OneToMany(mappedBy="manager",fetch = FetchType.LAZY)
 
 private List<Employee> employees;
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="manager_id")
 private Employee manager;
 //...
 // getter y setters removidos para resumir
 //...
 
 public Employee() {	
	}
 


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public List<Employee> getEmployees() {
	return employees;
}

public void setEmployees(List<Employee> employees) {
	this.employees = employees;
}

public Employee getManager() {
	return manager;
}

public void setManager(Employee manager) {
	this.manager = manager;
}
 
@PrePersist
public void onCreate() {
	this.createdAt = new Date();
}

@PreUpdate
public void onUpdate() {
	this.updatedAt = new Date();
}
}
