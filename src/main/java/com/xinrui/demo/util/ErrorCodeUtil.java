package com.xinrui.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorCodeUtil {

	private static final String RESOURCESE_NAME = "preadmessage.properties";
	private static Map<Integer, String> codeByMessageMap = new HashMap<Integer, String>();

	private static Properties properties = new Properties();

	private static Logger logger = LoggerFactory.getLogger(ErrorCodeUtil.class);
	
	static {
		Object o = new CodeConstants();
		java.lang.reflect.Field[] fs = o.getClass().getFields();
		try {
			for (int i = 0; i < fs.length; i++) {
				String fieldName = "";
				fieldName = fs[i].getName().replaceAll("_", ".").toLowerCase();
				if (fs[i].getType() == int.class) {
					codeByMessageMap.put(Integer.valueOf(fs[i].getInt(o)), fieldName);
				}
			}
		} catch (Exception e) {
			logger.error("这个地方会错???", e);
		}
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(RESOURCESE_NAME);
		try {
			properties.load(in);
		} catch (IOException e) {
			logger.error("加载" + RESOURCESE_NAME + "错误！", e);
		}
	}

	public static String getMessageByCode(int code) {
		return getMessage(codeByMessageMap.get(code));
	}

	private static String getMessage(String message) {
		return properties.get(message).toString();
	}

	public static void main(String[] args) {
		System.out.println(ErrorCodeUtil.getMessage("server.unknow"));
		System.out.println(ErrorCodeUtil.getMessageByCode(CodeConstants.SERVER_UNKNOW));

	}

}
