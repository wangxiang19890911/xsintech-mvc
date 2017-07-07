package com.xsintech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping(value="/secure/login")
	public String login() {
		return "app/taxfree_contract";
	}

	@RequestMapping(value="/secure/taxfree")
	public String texfree() {
		return "app/taxfree_contract";
	}
	
	@RequestMapping(value="/secure/labour")
	public String labour() {
		return "app/labour_contract";
	}
	
}
