package com.xsintech.service;

import com.xsintech.model.UserSave;

public interface UserService {
	public int checkLogin(String userName,String passWord);
	public void save(UserSave u);
	public int findOne(String userName);
	public String checkLogin1(String userName);
	public void up(UserSave u);
}
