package com.irisi.app.ws.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController()
public class HomeController {
	
	@GetMapping()
	public String hi() {
		return "done";
	}

}
