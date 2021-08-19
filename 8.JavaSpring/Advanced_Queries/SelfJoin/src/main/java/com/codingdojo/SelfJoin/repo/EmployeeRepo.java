package com.codingdojo.SelfJoin.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.SelfJoin.models.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long>{
	
	List<Employee> findAll(); 

}
