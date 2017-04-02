package com.xinrui.demo.util;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelConfig {

	protected static Logger logger = LoggerFactory.getLogger(ModelConfig.class);

	/**
	 * 模型属性配置文件
	 */
	public static String MODEL_PROPERTIES_PATH;

	public static String ROOT = "/home/tomcat/apache-tomcat-8.0.41/webapps";

	public static String BAYES_MODEL_FILE_PATH = "demo-web/Bayes/model/classify.txt";

	public static String BAYES_TRAIN_FILE_PATH = "demo-web/Bayes/files/";

	static {
		// 自动读取配置
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
		} catch (Exception e) {
			logger.error("模型属性配置文件读取错误:[" + e + "]");
		}

	}
}
