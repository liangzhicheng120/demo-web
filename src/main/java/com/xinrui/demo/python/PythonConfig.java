package com.xinrui.demo.python;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PythonConfig {

	private static Logger logger = Logger.getLogger(PythonConfig.class);

	/**
	 * 模型属性配置文件
	 */
	public static String PYTHON_PROPERTIES_PATH;
	/**
	 * python 安装包存放位置
	 */
	public static String ROOT = "E:/webworkspace/demo-ml/python/";

	public static String ML = "Lib/site-packages/ml/";
	// /**
	// * 贝叶斯模型存放位置
	// */
	// public static String BAYES_MODEL_FILES =
	// "Lib/site-packages/ml/bayes/model/";
	// /**
	// * 贝叶斯训练集存放位置
	// */
	// public static String BAYES_TRAIN_FILES =
	// "Lib/site-packages/ml/bayes/files/";
	// /**
	// * 百度百科爬虫py存放位置
	// */
	// public static String BAIKE_SPIDER_PY =
	// "Lib/site-packages/ml/baike/spider.py";
	// /**
	// * 贝叶斯py存放位置
	// */
	// public static String BAYES_BAYES_PY =
	// "Lib/site-packages/ml/bayes/bayes.py";

	static {
		Properties p = new Properties();
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			if (loader == null) {
				loader = PythonConfig.class.getClassLoader();
			}
			p.load(new InputStreamReader(PYTHON_PROPERTIES_PATH == null ? loader.getResourceAsStream("python.properties") : new FileInputStream(PYTHON_PROPERTIES_PATH), "UTF-8"));
			String root = p.getProperty("root", "").replaceAll("\\\\", "/");
			if (!root.endsWith("/")) {
				root += "/";
			}
			ML = root + p.getProperty("ml", ML);
		} catch (Exception e) {
			logger.error("模型属性配置文件读取错误:[" + e + "]");
		}

	}
}
