package com.irisi.app.ws.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.irisi.app.ws.services.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
   private final UserService userDatailsService ; 
   private final BCryptPasswordEncoder bCryptPasswordEncoder ; 
   
   public WebSecurity(UserService userDatailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userDatailsService = userDatailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	    .cors().and() //activation du cors 
	    .csrf().disable() //desactivation du csrf
	    .authorizeRequests() //Autoriser les requêtes Http 
	    .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL) // Autoriser la requete post /user
	    .permitAll() 
		.anyRequest().authenticated()
		.and()
		.addFilter(new AuthenticationFilter(authenticationManager())); ;
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDatailsService).passwordEncoder(bCryptPasswordEncoder);
	}


}
