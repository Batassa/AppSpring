package com.irisi.app.ws.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.irisi.app.ws.requests.UserRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="users")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4364292928391128911L;
	@Id
	@GeneratedValue
	private long id ; 
	@Column(nullable=false,length= 50)
	private String userId ; 
	@Column(nullable=false,length= 50)
	private String firstName ; 
	@Column(nullable=false,length= 50)
	private String LastName ; 
	@Column(nullable=false ,length= 50 , unique=true)
	private String email ; 
	@Column(nullable=false)
	private String encryptePassword ; 
	@Column(nullable=true)
	private String emailVerificationToken ; 
	@Column(nullable=false)
	private Boolean emailVerificationStatus = false ; 
	
	
	

}
