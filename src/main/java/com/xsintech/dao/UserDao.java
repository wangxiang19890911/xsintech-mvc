package com.xsintech.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xsintech.model.User;

public interface UserDao {
	public User find(@Param("userName")String userName,@Param("passWord")String passWord);
	public void save(User u);
	public int findOne(@Param("userName")String userName);
	public String find1(@Param("userName")String userName);
	public void up(User u);
	public List<User> findName(String userName);
}
