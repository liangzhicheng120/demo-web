package com.xinrui.demo.service;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import com.xinrui.demo.bean.Recommend;

public interface RecommendService {

	public List<RecommendedItem> userBaseRecommend(int uid);

	public void save(int nid, String clzss, String label, int aid);

	public void delete(String nid);

	public void update(Recommend recommend);

}
