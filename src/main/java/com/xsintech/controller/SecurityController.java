package com.xsintech.controller;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.xsintech.service.UserService;

@Controller
public class SecurityController {
	@Resource
	private UserService userService;

//	@RequestMapping(value="/secure/login")
//	public String login() {
//		return "app/taxfree_contract";
//	}
	
	
	@RequestMapping(value="/taxfree")
	public String texfree(String page,Model model){
		
		return "app/taxfree_contract";
	}
	
	@RequestMapping(value="/labour")
	public String labour() {
		return "app/labour_contract";
		
	}
	
	/**
	 * 插入合同页面跳转
	 * @return
	 */
	@RequestMapping(value="into")
	public String insertin(){
		return "app/new-built";
	}
	
	/**
	 * 删除合同页面跳转
	 * @return
	 */
	@RequestMapping(value="delete/de")
	public String delete(){
		return "app/delete_contract";
	}
	
	/**
	 * 个人设定跳转
	 * @return
	 */
	@RequestMapping(value = "/settings")
	public String settings(){
		return"setting";
	
	}
}
