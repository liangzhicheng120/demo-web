package com.xinrui.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.bean.UserInfo;
import com.xinrui.demo.dao.UserInfoDao;
import com.xinrui.demo.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public void add(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public UserInfo getPasswordByName(String name) {
		UserInfo userInfo = new UserInfo();
		userInfo.setName(name);
		return userInfoDao.getPasswordByName(userInfo);
	}

}
