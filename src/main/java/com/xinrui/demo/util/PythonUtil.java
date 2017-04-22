package com.xinrui.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.xinrui.demo.exception.CalException;

/**
 * python处理工具
 * 
 * @author XinRui
 *
 */
public class PythonUtil {

	private static Logger logger = Logger.getLogger(PythonUtil.class);

	public static void Process(String PyClassPath) {
		try {
			Process pr = Runtime.getRuntime().exec(ModelConfig.PYTHON_PROCESS_PATH + " " + PyClassPath);
			String error = new BufferedReader(new InputStreamReader(pr.getInputStream())).readLine();
			if (error != null) {
				logger.error(error);
				throw new CalException(CodeConstants.PYTHON_CLASS_ERROR, error);
			}
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}
	}
}
