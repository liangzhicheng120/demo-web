package com.xinrui.demo.python;


public class PyConstants {
	/**
	 * ml project
	 */
	public static class ml {
		/**
		 * ml project path
		 */
		public static final String ML_PROJECT = PythonConfig.PROJECT + "/ml";
		/**
		 * baike.py 百度百科爬虫 [ clzss,label,mid]=[类别,标签,标识]
		 */
		public static final String BAIKE_PY = ML_PROJECT + "/baike/baike.py";
		/**
		 * bayes.py 创建贝叶斯模型[mid]=[标识]
		 */
		public static final String BAYES_PY = ML_PROJECT + "/bayes/bayes.py";
		/**
		 * bayes model 贝叶斯模型文件存放位置
		 */
		public static final String BAYES_MODEL = ML_PROJECT + "/model/";
		/**
		 * bayes train set 贝叶斯训练集文件
		 */
		public static final String BAYES_TRAIN = ML_PROJECT + "/train/";
		/**
		 * 协同过滤算法模型文件位置
		 */
		public static final String CF_MODEL_FILE = ML_PROJECT + "/cf/user.txt";
	}

}
