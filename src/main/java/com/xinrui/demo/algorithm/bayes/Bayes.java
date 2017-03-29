package com.xinrui.demo.algorithm.bayes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 贝叶斯计算器主体类
 */
public class Bayes {

	/**
	 * 将原训练元组按类别划分
	 * 
	 * @param datas
	 *            训练元组
	 * @return Map<类别，属于该类别的训练元组>
	 */
	public Map<String, ArrayList<ArrayList<String>>> classifyByCategory(ArrayList<ArrayList<String>> datas) {
		if (datas == null) {
			return null;
		}

		Map<String, ArrayList<ArrayList<String>>> map = new HashMap<String, ArrayList<ArrayList<String>>>();
		ArrayList<String> singleTrainning = null;
		String classificaion = "";
		for (int i = 0; i < datas.size(); i++) {
			singleTrainning = datas.get(i);
			classificaion = singleTrainning.get(0);
			singleTrainning.remove(0);
			if (map.containsKey(classificaion)) {
				map.get(classificaion).add(singleTrainning);
			} else {
				ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
				list.add(singleTrainning);
				map.put(classificaion, list);
			}
		}

		return map;
	}

	/**
	 * 在训练数据的基础上预测测试元组的类别
	 * 
	 * @param datas
	 *            训练元组
	 * @param testData
	 *            测试元组
	 * @return 测试元组的类别
	 */
	public String predictClassify(ArrayList<ArrayList<String>> datas, ArrayList<String> testData) {
		if (datas == null || testData == null) {
			return null;
		}

		int maxPIndex = -1;
		Map<String, ArrayList<ArrayList<String>>> map = classifyByCategory(datas);
		Object[] classes = map.keySet().toArray();
		double maxProbability = 0.0;
		for (int i = 0; i < map.size(); i++) {
			double p = 0.0;
			for (int j = 0; j < testData.size(); j++) {
				p += calProbabilityClassificationInKey(map, classes[i].toString(), testData.get(j));
			}
			
//			System.out.println(classes[i] + " " + p);
//			if (p != 0) {
//				System.out.println(classes[i] + " " + p);
//			}

			if (p > maxProbability) {
				maxProbability = p;
				maxPIndex = i;
			}
		}

		return maxPIndex == -1 ? "未发现合适分类" : classes[maxPIndex].toString();
	}

	/**
	 * 在训练数据的基础上预测测试元组的类别
	 * 
	 * @param testData
	 *            测试元组
	 * @return 测试元组的类别
	 */
	public String predictClassify(ArrayList<String> testData) {
		return predictClassify(BayesFileTools.read("D:\\workspace\\eclipse-workspace\\demo-web\\src\\main\\java\\com\\xinrui\\demo\\algorithm\\bayes\\files\\trainset.txt"), testData);
	}

	/**
	 * 某一特征值在某一分类上的概率分布[ P(key|Classify) ]
	 * 
	 * @param classify
	 *            某一分类特征向量集
	 * @param value
	 *            某一特征值
	 * @return 概率分布
	 */
	private double calProbabilityKeyInClassification(ArrayList<ArrayList<String>> classify, String value) {
		if (classify == null || Tools.isEmptyString(value)) {
			return 0.0;
		}

		double p = 0.0;
		int totleKeyCount = 0;
		int foundKeyCount = 0;
		ArrayList<String> featureVector = null; // 分类中的某一特征向量
		for (int i = 0; i < classify.size(); i++) {
			featureVector = classify.get(i);
			for (int j = 0; j < featureVector.size(); j++) {
				totleKeyCount++;
				if (featureVector.get(j).equalsIgnoreCase(value)) {
					foundKeyCount++;
				}
			}
		}

		if (totleKeyCount == 0) {
			p = 0.0;
		} else {
			p = 1.0 * foundKeyCount / totleKeyCount;
		}

		return p;
	}

	/**
	 * 获得某一分类的概率 [ P(Classify) ]
	 * 
	 * @param classes
	 *            分类集合
	 * @param classify
	 *            某一特定分类
	 * @return 某一分类的概率
	 */
	private double calProbabilityClassification(Map<String, ArrayList<ArrayList<String>>> map, String classify) {
		if (map == null | Tools.isEmptyString(classify)) {
			return 0;
		}

		Object[] classes = map.keySet().toArray();
		int totleClassifyCount = 0;
		for (int i = 0; i < classes.length; i++) {
			totleClassifyCount += map.get(classes[i].toString()).size();
		}

		return 1.0 * map.get(classify).size() / totleClassifyCount;
	}

	/**
	 * 获得关键词的总概率
	 * 
	 * @param map
	 *            所有分类的数据集
	 * @param key
	 *            某一特征值
	 * @return 某一特征值在所有分类数据集中的比率
	 */
	private double calProbabilityKey(Map<String, ArrayList<ArrayList<String>>> map, String key) {
		if (map == null || Tools.isEmptyString(key)) {
			return 0;
		}

		double p = 0;
		int foundKeyCount = 0;
		int totleKeyCount = 0;
		Object[] classes = map.keySet().toArray();
		for (int i = 0; i < map.size(); i++) {
			ArrayList<ArrayList<String>> classify = map.get(classes[i]);
			ArrayList<String> featureVector = null; // 分类中的某一特征向量
			for (int j = 0; j < classify.size(); j++) {
				featureVector = classify.get(j);
				for (int k = 0; k < featureVector.size(); k++) {
					totleKeyCount++;
					if (featureVector.get(k).equalsIgnoreCase(key)) {
						foundKeyCount++;
					}
				}
			}
		}

		if (totleKeyCount == 0) {
			p = 0.0;
		} else {
			p = 1.0 * foundKeyCount / totleKeyCount;
		}

		return p;
	}

	/**
	 * 计算在出现key的情况下，是分类classify的概率 [ P(Classify | key) ]
	 * 
	 * @param map
	 *            所有分类的数据集
	 * @param classify
	 *            某一特定分类
	 * @param key
	 *            某一特定特征
	 * @return P(Classify | key)
	 */
	private double calProbabilityClassificationInKey(Map<String, ArrayList<ArrayList<String>>> map, String classify, String key) {
		ArrayList<ArrayList<String>> classifyList = map.get(classify);
		double pkc = calProbabilityKeyInClassification(classifyList, key); // p(key|classify)
		double pc = calProbabilityClassification(map, classify); // p(classify)
		double pk = calProbabilityKey(map, key); // p(key)
		double pck = 0.0; // p(classify | key)

		if (pk == 0) {
			pck = 0;
		} else {
			pck = pkc * pc / pk;
		}

		// System.out.println("P(" + classify + "|" + key + ") = " + pck);
		return pck;
	}
}
