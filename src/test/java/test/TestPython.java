package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.xinrui.demo.util.ModelConfig;

public class TestPython {
	public static void main(String[] args) {
		try {
			System.out.println(ModelConfig.PYTHON_PROCESS_PATH + " " + ModelConfig.PYTHON_BAIKE_CRAW_PATH);
			Process pr = Runtime.getRuntime().exec(ModelConfig.PYTHON_PROCESS_PATH + " " + ModelConfig.PYTHON_BAIKE_CRAW_PATH);
			String line = new BufferedReader(new InputStreamReader(pr.getInputStream())).readLine();
			System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
