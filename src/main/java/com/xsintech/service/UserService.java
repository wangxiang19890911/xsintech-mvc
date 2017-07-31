package com.xsintech.service;

import java.util.List;
import java.util.Map;

import com.xsintech.model.Contract;
import com.xsintech.model.UserSave;

public interface UserService {
	public UserSave checkLogin(String userName,String passWord);
	public void save(UserSave u);
	public int findOne(String userName);
	public String checkLogin1(String userName);
	public void up(UserSave u);
	public List<Contract> findfAll(Map map);
	public void insert(Contract u);
	public List<UserSave> findName(String userName);
	public int findTwo();
}
