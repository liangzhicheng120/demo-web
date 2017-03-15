package com.xinrui.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.bean.Admin;
import com.xinrui.demo.dao.AdminDao;
import com.xinrui.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public void add(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public Admin getPasswordByName(String name) {
		Admin admin = new Admin();
		admin.setName(name);
		return adminDao.getPasswordByName(admin);
	}

}
