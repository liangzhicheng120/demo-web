package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.xinrui.demo.exception.CalException;
import com.xinrui.demo.util.CodeConstants;
import com.xinrui.demo.util.ModelConfig;

public class TestPython {
	private static Logger logger = Logger.getLogger(ModelConfig.class);

	public static void main(String[] args) {
		try {
			Process pr = Runtime.getRuntime().exec(ModelConfig.PYTHON_PROCESS_PATH + " " + ModelConfig.PYTHON_BAIKE_CRAW_PATH);
			String error = new BufferedReader(new InputStreamReader(pr.getInputStream())).readLine();
			if (error != null) {
				logger.error(error);
				throw new CalException(CodeConstants.PYTHON_CLASS_ERROR, error);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
