package com.xinrui.demo.service;

import com.xinrui.demo.bean.Recommend;

public interface RecommendService {

	public void save(int nid, String clzss, String label, int aid);

	public void delete(String nid);

	public void update(Recommend recommend);

}
