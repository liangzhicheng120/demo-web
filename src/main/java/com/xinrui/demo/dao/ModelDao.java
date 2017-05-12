package com.xinrui.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xinrui.demo.bean.Model;

@Repository
public interface ModelDao {

	public void delete(String clzss);

	public void update(Model model);

	public List<Model> get(Model model);
	
}
