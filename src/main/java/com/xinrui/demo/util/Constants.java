package com.xinrui.demo.util;

public class Constants {
	/**
	 * 验证码key
	 */
	public static final String KAPTCHA_SESSION_KEY = "KAPTCHA_SESSION_KEY";
	/**
	 * 用户密码加密 盐值
	 */
	public static final String SALT = "DEMO-WEB";
	
	/**
	 * tomcat根目录 
	 */
//	public static final String TOMCAT_HOME = "/home/tomcat/apache-tomcat-8.0.41/webapps";
	public static final String TOMCAT_HOME = "E:/webworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps";

	/**
	 * 贝叶斯参数模型地址
	 */
	public static final String BAYES_MODEL = TOMCAT_HOME + "/demo-web/Bayes/model/classify.txt";

	/**
	 * 训练文件地址
	 */
	public static final String TRAIN_FILE = TOMCAT_HOME + "/demo-web/Bayes/files/";
}
