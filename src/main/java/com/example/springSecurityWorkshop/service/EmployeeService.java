package com.example.springSecurityWorkshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springSecurityWorkshop.entity.Employee;
import com.example.springSecurityWorkshop.repository.EmployeeRepository;


@Service
public class EmployeeService {
	// Field, Constructor, Setter
	@Autowired
	private EmployeeRepository repo;
	
	
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}
}