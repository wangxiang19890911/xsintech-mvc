package com.xsintech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value = "/")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/index")
	public String index() {
		return "app/index";
	}
}
