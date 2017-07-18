package com.xsintech.service.impl;

import javax.annotation.Resource;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.stereotype.Service;

import com.xsintech.dao.UserDao;
import com.xsintech.model.User;
import com.xsintech.service.UserService;

@Service("userServiec")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDAO;

	public int checkLogin(String userName, String passWord) {
		return userDAO.find(userName,passWord);
	}
}
