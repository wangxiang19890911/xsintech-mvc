package com.xsintech.service;

import java.util.List;
import com.xsintech.model.User;

public interface UserService {
	public User checkLogin(String userName,String passWord);
	public void save(User u);
	public int findOne(String userName);
	public String checkLogin1(String userName);
	public void up(User u);
	public List<User> findName(String userName);
}
