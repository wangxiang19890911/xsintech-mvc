package com.xsintech.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsintech.model.Contract;
import com.xsintech.service.UserService;

@Controller
public class SecurityController {
	@Resource
	private UserService userService;

	@RequestMapping(value="/secure/login")
	public String login() {
		return "app/taxfree_contract";
	}

	@RequestMapping(value="/secure/taxfree")
	@ResponseBody
	public List<Contract> texfree(String page,Model model){
		System.out.println(page);
		if(page==null){
		page="0";
		}
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("index", Integer.parseInt(page));
		map.put("index1", Integer.parseInt(page)+4);
		List<Contract> con =userService.findfAll(map);
		return con;
	}
	
	@RequestMapping(value="/secure/labour")
	public String labour() {
		return "app/labour_contract";
	}

}
