package com.xinrui.demo.service.impl;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.stereotype.Service;

import com.xinrui.demo.algorithm.mahout.Recommender;
import com.xinrui.demo.python.PyConstants;
import com.xinrui.demo.service.RecommenderService;

@Service
public class RecommenderServiceImpl implements RecommenderService {

	@Override
	public List<RecommendedItem> userBaseRecommend(int uid) {
		Recommender recommender = new Recommender(2, 3);
		List<RecommendedItem> recommendations = recommender.userBaseRecommend(uid, PyConstants.ml.CF_MODEL_FILE);
		return recommendations;
	}

}
