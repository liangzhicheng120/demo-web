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

	public static String PYTHON_PROCESS_PATH = "process/Python27/python.exe";

	public static String BAYES_MODEL_FILE_PATH = "pyclass/bayes/model";

	public static String BAYES_TRAIN_FILE_PATH = "pyclass/bayes/files/";

	public static String SPIDER_PY = "pyclass/baike/spider.py";

	public static String MAKE_MODEL_PY = "pyclass/bayes/make_model.py";

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
			SPIDER_PY = root + p.getProperty("baike.spider.py", SPIDER_PY);
			MAKE_MODEL_PY = root + p.getProperty("bayes.make.model.py", MAKE_MODEL_PY);

		} catch (Exception e) {
			logger.error("模型属性配置文件读取错误:[" + e + "]");
		}

	}
}
