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

	public static String ROOT = "E:/webworkspace/demo-ml";

	public static String BAYES_MODEL_FILE_PATH = "bayes/model/classify.txt";

	public static String BAYES_TRAIN_FILE_PATH = "bayes/files/";

	public static String PYTHON_PROCESS_PATH = "python/process/Python27/python.exe";

	public static String PYTHON_BAIKE_CRAW_PATH = "python/pyclass/baikecraw/BaikeCraw.py";

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
			
			BAYES_MODEL_FILE_PATH = root + p.getProperty("bayes.model.file.path", BAYES_MODEL_FILE_PATH);
			BAYES_TRAIN_FILE_PATH = root + p.getProperty("bayes.train.file.path", BAYES_TRAIN_FILE_PATH);
			PYTHON_PROCESS_PATH = root + p.getProperty("python.process.path", PYTHON_PROCESS_PATH);
			PYTHON_BAIKE_CRAW_PATH = root + p.getProperty("python.baike.craw.path", PYTHON_BAIKE_CRAW_PATH);
			
		} catch (Exception e) {
			logger.error("模型属性配置文件读取错误:[" + e + "]");
		}

	}
}
