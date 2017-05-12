package com.xinrui.demo.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.bean.Recommend;
import com.xinrui.demo.dao.RecommendDao;
import com.xinrui.demo.service.RecommendService;

@Service
public class RecommendServiceImpl implements RecommendService {

	private static Logger logger = Logger.getLogger(RecommendServiceImpl.class);

	@Autowired
	private RecommendDao recommendDao;

	@Transactional
	public void save(int nid, String clzss, String label, int aid) {
		Recommend recommend = new Recommend();
		recommend.setNid(nid);
		recommend.setClzss(clzss);
		recommend.setLabel(label);
		recommend.setAid(aid);
		recommendDao.save(recommend);
	}

	@Transactional
	public void delete(String nid) {
		Recommend recommend = new Recommend();
		recommend.setNid(Integer.valueOf(nid));
		recommendDao.delete(recommend);
	}

	@Transactional
	public void update(Recommend recommend) {
		logger.info(recommend.toString());
		recommendDao.update(recommend);
	}

}
