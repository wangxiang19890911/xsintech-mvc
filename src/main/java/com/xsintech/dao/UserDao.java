package com.xsintech.dao;

import org.apache.ibatis.annotations.Param;
import com.xsintech.model.UserSave;

public interface UserDao {
	public int find(@Param("userName")String userName,@Param("passWord")String passWord);
	public void save(UserSave u);
	public int findOne(@Param("userName")String userName);
	public String find1(@Param("userName")String userName);
	public void up(UserSave u);
}
