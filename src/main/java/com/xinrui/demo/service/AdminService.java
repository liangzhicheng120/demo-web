package com.xinrui.demo.service;

import com.xinrui.demo.bean.Admin;

public interface AdminService {

	public Admin getPasswordByName(String name);

	public void save(String username, String password) throws Exception;
}
