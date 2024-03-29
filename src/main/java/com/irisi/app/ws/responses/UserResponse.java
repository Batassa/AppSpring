package com.irisi.app.ws.responses;


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
public class UserResponse {

	private String userId ; 
	private String firstName ; 
	private String lastName ;
	private String email ; 
	 
	
}
