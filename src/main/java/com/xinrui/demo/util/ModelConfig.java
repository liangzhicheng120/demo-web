package com.xinrui.demo.util;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ModelConfig {

	private static Logger logger = Logger.getLogger(ModelConfig.class);

	/**
	 * 模型属性配置文件
	 */
	public static String MODEL_PROPERTIES_PATH;

	public static String ROOT = "E:/webworkspace/demo-ml/python";

	public static String PYTHON_EXE = "python.exe";

	public static String BAYES_MODEL_FILES = "Lib/site-packages/ml/bayes/model/";

	public static String BAYES_TRAIN_FILES = "Lib/site-packages/ml/bayes/files/";

	public static String BAIKE_SPIDER_PY = "Lib/site-packages/ml/baike/spider.py";

	public static String BAYES_BAYES_PY = "Lib/site-packages/ml/bayes/bayes.py";

	static {
		Properties p = new Properties();
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			if (loader == null) {
				loader = ModelConfig.class.getClassLoader();
			}
			p.load(new InputStreamReader(MODEL_PROPERTIES_PATH == null ? loader.getResourceAsStream("model.properties") : new FileInputStream(
					MODEL_PROPERTIES_PATH), "UTF-8"));
			String root = p.getProperty("root", "").replaceAll("\\\\", "/");
			if (!root.endsWith("/")) {
				root += "/";
			}

			BAYES_MODEL_FILES = root + p.getProperty("bayes.model.files", BAYES_MODEL_FILES);
			BAYES_TRAIN_FILES = root + p.getProperty("bayes.train.files", BAYES_TRAIN_FILES);
			PYTHON_EXE = root + p.getProperty("python.exe", PYTHON_EXE);
			BAIKE_SPIDER_PY = root + p.getProperty("baike.spider.py", BAIKE_SPIDER_PY);
			BAYES_BAYES_PY = root + p.getProperty("bayes.bayes.py", BAYES_BAYES_PY);

		} catch (Exception e) {
			logger.error("模型属性配置文件读取错误:[" + e + "]");
		}

	}
}
