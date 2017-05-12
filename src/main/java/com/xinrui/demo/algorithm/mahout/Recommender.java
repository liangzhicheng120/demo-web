package com.xinrui.demo.algorithm.mahout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.ClusterSimilarity;
import org.apache.mahout.cf.taste.impl.recommender.knn.NonNegativeQuadraticOptimizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.ALSWRFactorizer;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.xinrui.demo.exception.CalException;
import com.xinrui.demo.util.code.CodeConstants;

@SuppressWarnings("deprecation")
public class Recommender {

	private static Logger logger = Logger.getLogger(Recommender.class);

	private final static int NEIGHBORHOOD_NUM = 2;

	private final static int RECOMMENDER_NUM = 3;

	/**
	 * 
	 * @param uid
	 *            用户ID
	 * @param modelName
	 *            模型文件位置
	 * @return
	 */
	public static List<RecommendedItem> userBaseRecommend(int uid, String modelName) {
		List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
		try {
			DataModel dataModel = new FileDataModel(new File(modelName));
			UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.EUCLIDEAN, dataModel);
			UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.NEAREST, userSimilarity, dataModel, NEIGHBORHOOD_NUM);
			RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, true);
			RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
			RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 2);
			recommendations = recommenderBuilder.buildRecommender(dataModel).recommend(uid, RECOMMENDER_NUM);
		} catch (Exception e) {
			logger.error(e);
			throw new CalException(CodeConstants.RECOMMENDER_CLASS_ERROR, e);
		}
		return recommendations;
	}

	/**
	 * 
	 * @param uid
	 *            用户ID
	 * @param modelName
	 *            模型文件位置
	 * @return
	 */
	public static List<RecommendedItem> itemBaseRecommend(int uid, String modelName) {
		List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
		try {
			DataModel dataModel = new FileDataModel(new File(modelName));
			ItemSimilarity itemSimilarity = RecommendFactory.itemSimilarity(RecommendFactory.SIMILARITY.EUCLIDEAN, dataModel);
			RecommenderBuilder recommenderBuilder = RecommendFactory.itemRecommender(itemSimilarity, true);
			RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
			RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 2);
			recommendations = recommenderBuilder.buildRecommender(dataModel).recommend(uid, RECOMMENDER_NUM);
		} catch (Exception e) {
			logger.error(e);
			throw new CalException(CodeConstants.RECOMMENDER_CLASS_ERROR, e);
		}
		return recommendations;
	}

	/**
	 * 
	 * @param uid
	 *            用户ID
	 * @param modelName
	 *            模型文件位置
	 * @return
	 */
	public static List<RecommendedItem> slopeOne(int uid, String modelName) {
		List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
		try {
			DataModel dataModel = new FileDataModel(new File(modelName));
			RecommenderBuilder recommenderBuilder = RecommendFactory.slopeOneRecommender();
			RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
			RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 2);
			recommendations = recommenderBuilder.buildRecommender(dataModel).recommend(uid, RECOMMENDER_NUM);
		} catch (Exception e) {
			logger.error(e);
			throw new CalException(CodeConstants.RECOMMENDER_CLASS_ERROR, e);
		}
		return recommendations;
	}

	/**
	 * 
	 * @param uid
	 *            用户ID
	 * @param modelName
	 *            模型文件位置
	 * @return
	 */
	public static List<RecommendedItem> itemKNNRecommender(int uid, String modelName) {
		List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
		try {
			DataModel dataModel = new FileDataModel(new File(modelName));
			ItemSimilarity itemSimilarity = RecommendFactory.itemSimilarity(RecommendFactory.SIMILARITY.EUCLIDEAN, dataModel);
			RecommenderBuilder recommenderBuilder = RecommendFactory.itemKNNRecommender(itemSimilarity, new NonNegativeQuadraticOptimizer(), 10);
			RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
			RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 2);
			recommendations = recommenderBuilder.buildRecommender(dataModel).recommend(uid, RECOMMENDER_NUM);
		} catch (Exception e) {
			logger.error(e);
			throw new CalException(CodeConstants.RECOMMENDER_CLASS_ERROR, e);
		}
		return recommendations;
	}

	/**
	 * 
	 * @param uid
	 *            用户ID
	 * @param modelName
	 *            模型文件位置
	 * @return
	 */
	public static List<RecommendedItem> svdRecommender(int uid, String modelName) {
		List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
		try {
			DataModel dataModel = new FileDataModel(new File(modelName));
			RecommenderBuilder recommenderBuilder = RecommendFactory.svdRecommender(new ALSWRFactorizer(dataModel, 10, 0.05, 10));
			RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
			RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 2);
			recommendations = recommenderBuilder.buildRecommender(dataModel).recommend(uid, RECOMMENDER_NUM);
		} catch (Exception e) {
			logger.error(e);
			throw new CalException(CodeConstants.RECOMMENDER_CLASS_ERROR, e);
		}
		return recommendations;
	}

	public static List<RecommendedItem> treeClusterRecommender(int uid, String modelName) {
		List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
		try {
			DataModel dataModel = new FileDataModel(new File(modelName));
			UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.LOGLIKELIHOOD, dataModel);
			ClusterSimilarity clusterSimilarity = RecommendFactory.clusterSimilarity(RecommendFactory.SIMILARITY.FARTHEST_NEIGHBOR_CLUSTER, userSimilarity);
			RecommenderBuilder recommenderBuilder = RecommendFactory.treeClusterRecommender(clusterSimilarity, 10);
			RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
			RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 2);
			recommendations = recommenderBuilder.buildRecommender(dataModel).recommend(uid, RECOMMENDER_NUM);
		} catch (Exception e) {
			logger.error(e);
			throw new CalException(CodeConstants.RECOMMENDER_CLASS_ERROR, e);
		}
		return recommendations;
	}
}
