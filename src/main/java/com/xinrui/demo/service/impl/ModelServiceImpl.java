package com.xinrui.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.bean.Model;
import com.xinrui.demo.dao.ModelDao;
import com.xinrui.demo.service.ModelService;
import com.xinrui.demo.util.sql.SqlUtils;

@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	private ModelDao modelDao;

	@Transactional
	public void delete(String clzss) {
		modelDao.delete(clzss);
	}

	@Transactional
	public void update(String clzss, String label, String keyword) {
		Model model = new Model(clzss, label);
		for (String word : keyword.split(",")) {
			model.setKeyword(SqlUtils.escapeSQLLike(word));
			if (modelDao.get(model).isEmpty()) {
				modelDao.update(model);
			}
		}
	}

}
