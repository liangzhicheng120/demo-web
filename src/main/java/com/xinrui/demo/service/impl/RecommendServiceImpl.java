package com.xinrui.demo.service.impl;

import java.util.List;

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

	@Autowired
	private RecommendDao recommendDao;

	@Override
	public List<RecommendedItem> userBaseRecommend(int uid) {
		Recommender recommender = new Recommender(2, 3);
		List<RecommendedItem> recommendations = recommender.userBaseRecommend(uid, PyConstants.ml.CF_MODEL_FILE);
		return recommendations;
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

}
