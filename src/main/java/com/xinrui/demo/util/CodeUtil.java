package com.xinrui.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class CodeUtil {

	private static Logger logger = Logger.getLogger(CodeUtil.class);

	private static final String RESOURCESE_NAME = "code.properties";

	private static Map<Integer, String> codeByMessageMap = new HashMap<Integer, String>();

	private static Properties properties = new Properties();

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
			logger.error("格式化错误:", e);
		}
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(RESOURCESE_NAME);
		try {
			properties.load(in);
		} catch (IOException e) {
			logger.error("加载[" + RESOURCESE_NAME + "]错误！", e);
		}
	}

	public static String getMessageByCode(int code) {
		return getMessage(codeByMessageMap.get(code));
	}

	private static String getMessage(String message) {
		return properties.get(message).toString();
	}

}
