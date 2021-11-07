package com.irisi.app.ws.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.irisi.app.ws.shared.dto.UserDto;


public interface UserService extends UserDetailsService {

	  UserDto createUser(UserDto userDto) ; 
}
