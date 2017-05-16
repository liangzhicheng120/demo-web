package com.xinrui.demo.service;

import java.util.List;

import com.xinrui.demo.bean.Model;

public interface ModelService {

	public void delete(String clzss);

	public void update(String clzss, String label, String keyword);

	public List<Model> getByClzss(String clzss);

	public Model getById(String id);

	public void updateKeyword(String id, String keyword);
}
