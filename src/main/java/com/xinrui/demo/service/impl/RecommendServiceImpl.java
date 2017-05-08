package com.xinrui.demo.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.algorithm.mahout.Recommender;
import com.xinrui.demo.bean.Recommend;
import com.xinrui.demo.dao.RecommendDao;
import com.xinrui.demo.python.PyConstants;
import com.xinrui.demo.service.RecommendService;

@Service
public class RecommendServiceImpl implements RecommendService {

	private static Logger logger = Logger.getLogger(RecommendServiceImpl.class);

	@Autowired
	private RecommendDao recommendDao;

	@Override
	public List<RecommendedItem> userBaseRecommend(int uid) {
		return Recommender.userBaseRecommend(uid, PyConstants.ml.CF_MODEL, 2, 3);
	}

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
		logger.info(String.format("recommend:{0}", recommend.toString()));
		recommendDao.update(recommend);
	}

}
