package com.xinrui.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.dao.ModelDao;
import com.xinrui.demo.service.ModelService;
@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	private ModelDao modelDao;

	@Transactional
	public void delete(String clzss) {
		modelDao.delete(clzss);
	}

}
