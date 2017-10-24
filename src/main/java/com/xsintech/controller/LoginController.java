package com.xsintech.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsintech.model.User;
import com.xsintech.model.ValidationResult;
import com.xsintech.service.UserService;
import com.xsintech.util.MailUtil;

@Controller
public class LoginController {
	
}

