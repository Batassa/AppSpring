package com.irisi.app.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irisi.app.ws.entities.UserEntity;

@Repository
public interface  UserRepository extends JpaRepository<UserEntity,Long> {
 
	UserEntity findByEmail(String email);
	
}
