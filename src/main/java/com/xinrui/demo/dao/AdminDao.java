package com.xinrui.demo.dao;

import org.springframework.stereotype.Repository;

import com.xinrui.demo.bean.Admin;

@Repository
public interface AdminDao {
	
	public void add(Admin userInfo);

	public Admin getPasswordByName(Admin userInfo);
	
	
}
