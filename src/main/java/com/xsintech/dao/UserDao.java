package com.xsintech.dao;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
	public int find(@Param("userName") String userName,@Param("passWord")String passWord);
	
}
