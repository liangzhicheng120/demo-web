package com.xinrui.demo.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.bean.Model;
import com.xinrui.demo.dao.ModelDao;
import com.xinrui.demo.python.PyConstants;
import com.xinrui.demo.python.PythonUtil;
import com.xinrui.demo.service.ModelService;
import com.xinrui.demo.util.StringUtil;
import com.xinrui.demo.util.encrypt.EncryptUtil;

@Service
public class ModelServiceImpl implements ModelService {

	private static Logger logger = Logger.getLogger(ModelServiceImpl.class);

	@Autowired
	private ModelDao modelDao;

	@Transactional
	public void delete(String clzss) {
		modelDao.delete(clzss);
	}

	@Transactional
	public void update(String clzss, String label, String keyword) {
		try {
			Model model = new Model(clzss, label);
			for (String word : StringUtils.split(keyword, ",")) {
				model.setKeyword(word);
				modelDao.update(model);
			}
			PythonUtil.run(PyConstants.ml.BAYES_PY, EncryptUtil.HMACMD5(clzss), label);
			logger.info(String.format("update %s bayes model", clzss));
		} catch (Exception e) {
			logger.error(String.format("[bayes model create error] %s", e));
		}
	}

	@Transactional
	public List<Model> getByClzss(String clzss) {
		Model model = new Model();
		model.setClzss(clzss);
		return modelDao.getByClzss(model);
	}

	@Transactional
	public Model getById(String id) {
		Model model = new Model();
		if (StringUtil.isNumeric(id)) {
			model.setId(Integer.valueOf(id));
			model = modelDao.getById(model);
		}
		return model;
	}

	@Transactional
	public void updateKeyword(String id, String keyword) {
		Model model = new Model();
		model.setId(Integer.valueOf(id));
		model.setKeyword(keyword.replace("，", ","));
		modelDao.updateKeyword(model);
	}
}
