package com.xinrui.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.bean.Admin;
import com.xinrui.demo.dao.AdminDao;
import com.xinrui.demo.service.AdminService;
import com.xinrui.demo.util.Constants;
import com.xinrui.demo.util.EncryptUtil;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Transactional
	public Admin getPasswordByName(String name) {
		Admin admin = new Admin();
		admin.setName(name);
		return adminDao.getPasswordByName(admin);
	}

	@Transactional
	public void save(String username, String password) throws Exception {
		Admin admin = new Admin();
		admin.setName(username);
		admin.setPassword(EncryptUtil.encryptMD5(username + password + Constants.SALT));
		adminDao.save(admin);
	}

}
