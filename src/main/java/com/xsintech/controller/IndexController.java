package com.xsintech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value="/")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/index")
	public String index() {
		// 读取本地的word文档
		
		// 将画面上输入的情报,写入word位置
		return "index";
	}
}
