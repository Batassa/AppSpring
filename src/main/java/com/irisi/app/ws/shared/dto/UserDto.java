package com.irisi.app.ws.shared.dto;

import java.io.Serializable;

import com.irisi.app.ws.requests.UserRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1185539654867288964L;
	private long id ; 
	private String userId ; 
	private String firstName ; 
	private String LastName ; 
	private String email ; 
	private String password ; 
	private String encryptePassword ; 
	private String emailVerificationToken ; 
	private Boolean emailVerificationStatus = false; 
	
	
}
