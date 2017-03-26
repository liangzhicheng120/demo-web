package com.xinrui.demo.dao;

import org.springframework.stereotype.Repository;

import com.xinrui.demo.bean.Admin;

@Repository
public interface AdminDao {

	public Admin getPasswordByName(Admin userInfo);
	
	public void save(Admin admin);
}
