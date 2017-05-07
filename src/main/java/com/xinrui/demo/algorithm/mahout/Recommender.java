package com.xinrui.demo.algorithm.mahout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.xinrui.demo.exception.CalException;
import com.xinrui.demo.util.code.CodeConstants;

public class Recommender {

	private static Logger logger = Logger.getLogger(Recommender.class);

	/**
	 * 
	 * @param uid
	 *            用户id
	 * @param modelName
	 *            模型文件位置
	 * @param neighborhoodNum
	 *            邻居数量
	 * @param recommenderNum
	 *            推荐数量
	 * @return
	 */
	public static List<RecommendedItem> userBaseRecommend(int uid, String modelName, int neighborhoodNum, int recommenderNum) {
		List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
		try {
			DataModel model = new FileDataModel(new File(modelName));
			UserSimilarity user = new EuclideanDistanceSimilarity(model);
			NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(neighborhoodNum, user, model);
			GenericUserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighbor, user);
			recommendations = recommender.recommend(uid, recommenderNum);
		} catch (Exception e) {
			logger.error(e);
			throw new CalException(CodeConstants.RECOMMENDER_CLASS_ERROR, e);
		}
		return recommendations;
	}

	public static List<RecommendedItem> itemBaseRecommend(int uid, String modelName, int recommenderNum) {
		List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
		try {
			DataModel model = new FileDataModel(new File(modelName));
			ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
			GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(model, similarity);
			recommendations = recommender.recommend(uid, recommenderNum);
		} catch (Exception e) {
			logger.error(e);
			throw new CalException(CodeConstants.RECOMMENDER_CLASS_ERROR, e);
		}
		return recommendations;
	}
}
