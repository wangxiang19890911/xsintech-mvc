package com.xsintech.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xsintech.dao.UserDao;
import com.xsintech.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDAO;

}
