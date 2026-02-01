package com.example.springSecurityWorkshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springSecurityWorkshop.dto.LoginDto;
import com.example.springSecurityWorkshop.dto.RegisterDto;
import com.example.springSecurityWorkshop.entity.Employee;
import com.example.springSecurityWorkshop.repository.EmployeeRepository;

@Service
public class AuthService {
	
	@Autowired
	private EmployeeRepository repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public Employee register(RegisterDto input) {
		
		Employee employee = new Employee();
		employee.setName(input.getName());
		employee.setEmail(input.getEmail());
		employee.setPassword(passwordEncoder.encode(input.getPassword()));
		employee.setRole(input.getRole());
		
		return repo.save(employee);
		
	}
	
	 public Employee authenticate(LoginDto input) {

	        authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(input.getEmail(),input.getPassword())
	        );

	        return repo.findByEmail(input.getEmail());

	    }
	

}
