package com.xinrui.demo.service;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public interface RecommenderService {
	public List<RecommendedItem> userBaseRecommend(int uid);
}
