package com.xinrui.demo.dao;

import org.springframework.stereotype.Repository;

import com.xinrui.demo.bean.UserInfo;

@Repository
public interface UserInfoDao {
	
	public void add(UserInfo userInfo);

	public UserInfo getPasswordByName(UserInfo userInfo);
	
	
}
