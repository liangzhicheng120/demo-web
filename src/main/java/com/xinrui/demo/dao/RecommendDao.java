package com.xinrui.demo.dao;

import org.springframework.stereotype.Repository;

import com.xinrui.demo.bean.Recommend;

@Repository
public interface RecommendDao {

	public void save(Recommend recommend);

	public void delete(Recommend recommend);

	public void update(Recommend recommend);

}
