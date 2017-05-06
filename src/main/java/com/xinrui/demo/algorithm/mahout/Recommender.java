package com.xinrui.demo.algorithm.mahout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.xinrui.demo.exception.CalException;
import com.xinrui.demo.util.code.CodeConstants;

public class Recommender {

	private static Logger logger = Logger.getLogger(Recommender.class);

	/**
	 * 邻居数量
	 */
	private int NEIGHBORHOOD_NUM = 2;
	/**
	 * 推荐数量
	 */
	private int RECOMMENDER_NUM = 3;

	public Recommender() {

	}

	public Recommender(int NEIGHBORHOOD_NUM, int RECOMMENDER_NUM) {
		setNEIGHBORHOOD_NUM(NEIGHBORHOOD_NUM);
		setRECOMMENDER_NUM(RECOMMENDER_NUM);
	}

	public List<RecommendedItem> userBaseRecommend(int uid, String modelName) {
		List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
		try {
			DataModel model = new FileDataModel(new File(modelName));
			UserSimilarity user = new EuclideanDistanceSimilarity(model);
			NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, user, model);
			GenericUserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighbor, user);
			recommendations = recommender.recommend(uid, RECOMMENDER_NUM);
		} catch (Exception e) {
			logger.error(e);
			throw new CalException(CodeConstants.RECOMMENDER_CLASS_ERROR, e);
		}
		return recommendations;
	}

	public int getNEIGHBORHOOD_NUM() {
		return NEIGHBORHOOD_NUM;
	}

	public void setNEIGHBORHOOD_NUM(int nEIGHBORHOOD_NUM) {
		NEIGHBORHOOD_NUM = nEIGHBORHOOD_NUM;
	}

	public int getRECOMMENDER_NUM() {
		return RECOMMENDER_NUM;
	}

	public void setRECOMMENDER_NUM(int rECOMMENDER_NUM) {
		RECOMMENDER_NUM = rECOMMENDER_NUM;
	}

}
