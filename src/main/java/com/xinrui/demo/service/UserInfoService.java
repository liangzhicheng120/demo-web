package com.xinrui.demo.service;

import com.xinrui.demo.bean.UserInfo;

public interface UserInfoService {
	
	public void add(UserInfo userInfo);

	public UserInfo getPasswordByName(String name);
	
}
