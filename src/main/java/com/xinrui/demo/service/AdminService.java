package com.xinrui.demo.service;

import com.xinrui.demo.bean.Admin;

public interface AdminService {
	
	public void add(Admin userInfo);

	public Admin getPasswordByName(String name);
	
}
