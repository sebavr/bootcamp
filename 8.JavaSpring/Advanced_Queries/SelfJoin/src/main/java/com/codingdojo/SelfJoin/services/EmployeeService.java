package com.codingdojo.SelfJoin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.SelfJoin.models.Employee;
import com.codingdojo.SelfJoin.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
private final EmployeeRepo employeeRepo;
	
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public List<Employee> findAllEmployees() {
		return  employeeRepo.findAll();
		
	}
	
	public Employee findOneEmployee(Long id) {
		return employeeRepo.findById(id).orElse(null);
	}
	
	public Employee createEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}
	
	public void addManager(Long managerId, Long employeeId) {
		Optional<Employee> emp = employeeRepo.findById(employeeId);
		Optional<Employee> man = employeeRepo.findById(managerId);
		if (emp.isPresent() && man.isPresent()) {
			emp.get().setManager(man.get());
			employeeRepo.save(emp.get());
			List<Employee> employs = man.get().getEmployees();
			if (!employs.contains(emp.get())) {
				employs.add(emp.get());
				employeeRepo.save(man.get());
			}
		}
	}
	
	public void dropManager(Long managerId, Long employeeId) {
		Optional<Employee> emp = employeeRepo.findById(employeeId);
		Optional<Employee> man = employeeRepo.findById(managerId);
		if (emp.isPresent() && man.isPresent()) {
			emp.get().setManager(null);
			employeeRepo.save(emp.get());
			List<Employee> employs = man.get().getEmployees();
			if (employs.contains(emp.get())) {
				employs.remove(emp.get());
				employeeRepo.save(man.get());
			}
		}
	}
	
	

}
