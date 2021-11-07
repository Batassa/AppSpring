package com.irisi.app.ws.services.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.irisi.app.ws.entities.UserEntity;
import com.irisi.app.ws.repository.UserRepository;
import com.irisi.app.ws.services.UserService;
import com.irisi.app.ws.shared.dto.UserDto;


@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	UserRepository userRepository ;
	@Autowired 
	BCryptPasswordEncoder bCryptPasswordEncoder ;  
	
	@Override
	public UserDto createUser(UserDto user ) {
		
		 UserEntity checkUser = userRepository.findByEmail(user.getEmail()); 
		 if(checkUser != null) throw new RuntimeException("user Already Exixt ! ") ; 
		 UserEntity userEntity = new UserEntity();
		 BeanUtils.copyProperties(user, userEntity);
		 userEntity.setEncryptePassword(bCryptPasswordEncoder.encode(user.getPassword()));
		 //userEntity.setUserId("userTestId");
		 UserEntity newUser = userRepository.save(userEntity); 
		 UserDto userDto = new UserDto() ; 
    	 BeanUtils.copyProperties(newUser, userDto);
		 
		return userDto;
	}
	
	
	//Recuperer l'utilisateur authentifier dans la BD  (Dans cette cas On se base sur Email )
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
	   UserEntity userEntity = userRepository.findByEmail(email) ; 
	   if(userEntity == null ) throw new UsernameNotFoundException(email) ;  
		return new User(userEntity.getEmail(),userEntity.getEncryptePassword(), new ArrayList<>());
	}



}
