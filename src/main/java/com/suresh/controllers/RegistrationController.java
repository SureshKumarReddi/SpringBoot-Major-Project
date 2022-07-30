package com.suresh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.suresh.bindings.UserRequest;
import com.suresh.entities.RegisterUser;
import com.suresh.service.UserService;

@RestController
public class RegistrationController {

	@Autowired
	private UserService service;
	
	@PostMapping("/")
	public ResponseEntity<String> getSsn(@RequestBody UserRequest request){
		
		 String saveUser = service.saveUser(request);
		
		return new ResponseEntity<String>(saveUser + "is your registration number ",HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<RegisterUser> getAll(){
		return service.getAllUsers();
	}
}
