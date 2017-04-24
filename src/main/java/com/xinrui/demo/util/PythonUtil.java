package com.xinrui.demo.util;

import java.io.BufferedReader;
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

	public static void winProcess(String pyClassPath, String... args) {
		Process(ModelConfig.PYTHON_EXE + " " + pyClassPath + StringUtil.argsToString(args));
	}

	public static void linuxProcess(String pyClassPath, String... args) {
		Process("python" + " " + pyClassPath + StringUtil.argsToString(args));
	}

	public static void Process(String cmd) {
		try {
			Process pr = Runtime.getRuntime().exec(cmd);
			BufferedReader error = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String head = error.readLine();
			if (head != null) {
				logger.error(head);
				error.lines().forEach(e -> logger.error(e));
				throw new CalException(CodeConstants.PYTHON_CLASS_ERROR, "[ Python ProgrammingError ]");
			}
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
	}
}
