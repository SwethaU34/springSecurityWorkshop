package com.example.springSecurityWorkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springSecurityWorkshop.dto.LoginDto;
import com.example.springSecurityWorkshop.dto.RegisterDto;
import com.example.springSecurityWorkshop.entity.Employee;
import com.example.springSecurityWorkshop.service.AuthService;
import com.example.springSecurityWorkshop.service.JwtService;

@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/register")
	public Employee register(@RequestBody RegisterDto registerDto) {
	        Employee user = authService.register(registerDto);
	        return user;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDto loginDto) {
		Employee user = authService.authenticate(loginDto);
		String token = jwtService.generateToken(user);
		return token;
	}
}
