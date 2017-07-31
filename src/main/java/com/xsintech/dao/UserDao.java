package com.xsintech.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xsintech.model.Contract;
import com.xsintech.model.UserSave;

public interface UserDao {
	public UserSave find(@Param("userName")String userName,@Param("passWord")String passWord);
	public void save(UserSave u);
	public int findOne(@Param("userName")String userName);
	public String find1(@Param("userName")String userName);
	public void up(UserSave u);
	public List<Contract> findfAll(Map map);
	public void insert(Contract c);
	public List<UserSave> findName(@Param("userName")String userName);
	public int findTwo();
}
