package com.irisi.app.ws.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irisi.app.ws.requests.UserRequest;
import com.irisi.app.ws.responses.UserResponse;
import com.irisi.app.ws.services.UserService;
import com.irisi.app.ws.shared.dto.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired 
	UserService userService ; 
	
	@GetMapping("/")
	public String  getUsers() {
		return "get user was called ";
	}
	
	@PostMapping
	public UserResponse createUser(@RequestBody UserRequest userRequest ) {
		System.out.println("feeennnnn");
		UserDto userDto = new UserDto() ;
		BeanUtils.copyProperties(userRequest, userDto);
		UserDto creatUser = userService.createUser(userDto);
		UserResponse userResponse = new UserResponse() ; 
		BeanUtils.copyProperties(creatUser, userResponse);
		return userResponse ; 
	}
	
	public String updateUser() {
		return "update user was called ";
	}
	
	public  String deleteUser() {
		return "delete  user was called ";
	}
	
}
