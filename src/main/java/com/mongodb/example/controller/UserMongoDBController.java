package com.mongodb.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.example.document.User;
import com.mongodb.example.repository.UserRepository;

@RestController
@RequestMapping("/userservice")
public class UserMongoDBController {

	@Autowired
	private UserRepository userRepository;
	// Swagger ==> http://localhost:8085/swagger-ui.html 
	
	//not needed always
	//@ApiImplicitParams({ @ApiImplicitParam(paramType = "header", name = "x-locale", example = "en"),
	//@ApiImplicitParam(paramType = "body", dataType = "Employee") })
	@GetMapping("/find/all")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
