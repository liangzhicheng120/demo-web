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
	/**
	 * python 工程存放位置
	 */
	public static String PROJECT = "E:/webworkspace/demo-ml/python/Lib/site-packages";

	static {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			loader = (loader == null) ? PythonConfig.class.getClassLoader() : loader;
			Properties p = new Properties();
			p.load(new InputStreamReader(PYTHON_PROPERTIES_PATH == null ? loader.getResourceAsStream("python.properties") : new FileInputStream(PYTHON_PROPERTIES_PATH), "UTF-8"));
			ROOT = p.getProperty("root", ROOT);
			PROJECT = p.getProperty("project", PROJECT);
		} catch (Exception e) {
			logger.error("模型属性配置文件读取错误:[" + e + "]");
		}
	}
}
