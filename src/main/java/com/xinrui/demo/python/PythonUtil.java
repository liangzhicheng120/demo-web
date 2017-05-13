package com.xinrui.demo.python;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.python.core.PyException;

import com.xinrui.demo.exception.CalException;
import com.xinrui.demo.util.StringUtil;
import com.xinrui.demo.util.code.CodeConstants;
import com.xinrui.demo.util.os.OSInfoUtil;

/**
 * python处理工具
 * 
 * @author XinRui
 *
 */
public class PythonUtil {

	private static Logger logger = Logger.getLogger(PythonUtil.class);

	private static String command = "command";

	/**
	 * python 执行器
	 * 
	 * @param pyclass
	 *            [python执行类]
	 * @param args
	 *            [参数]
	 */
	public static String run(String pyclass, String... args) {
		if (OSInfoUtil.isWindows()) {
			command = String.format("%spython.exe %s%s", PythonConfig.ROOT, pyclass, StringUtil.argsToString(args));
		} else if (OSInfoUtil.isLinux()) {
			command = String.format("python %s%s", pyclass, StringUtil.argsToString(args));
		} else {
			String er = "操作系统错误,当前操作系统：[" + OSInfoUtil.getOsName() + "]";
			logger.error(er);
			throw new CalException(CodeConstants.OPERATING_SYSTEM_ERROR, er);
		}
		return process(command);
	}

	/**
	 * 
	 * @param command
	 *            [cmd执行命令]
	 */
	public static String process(String command) {
		String head = "";
		try {
			logger.info(String.format("[command] %s", command));
			Process pr = Runtime.getRuntime().exec(command);
			BufferedReader feedback = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			head = feedback.readLine();
			if (head != null && head.equals(PyConstants.ml.ERROR)) {
				logger.error(String.format("[process] %s", head));
				feedback.lines().forEach(e -> logger.error(e));
				throw new PyException();
			}
		} catch (Exception e) {
			logger.error(String.format("[process] %s", e));
			throw new CalException(CodeConstants.PYTHON_CLASS_ERROR, "[ Python ProgrammingError ]");
		}
		return head;
	}

}
