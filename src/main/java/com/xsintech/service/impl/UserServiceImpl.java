package com.xsintech.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.stereotype.Service;

import com.xsintech.dao.UserDao;
import com.xsintech.model.Contract;
import com.xsintech.model.User;
import com.xsintech.model.UserSave;
import com.xsintech.service.UserService;

@Service("userServiec")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDAO;

	public UserSave checkLogin(String userName, String passWord) {
		return userDAO.find(userName,passWord);
	}

	public void save(UserSave u) {
		 userDAO.save(u);
	}
	public int findOne(String userName) {
		return userDAO.findOne(userName);
	}

	public String checkLogin1(String userName) {
		return userDAO.find1(userName);
	}

	public void up(UserSave u) {
		userDAO.up(u);
	}

	public List<Contract> findfAll(Map map) {
		return userDAO.findfAll(map);
	}

}
