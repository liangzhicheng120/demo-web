package test;

import com.xinrui.demo.util.ModelConfig;
import com.xinrui.demo.util.PythonUtil;

public class TestPython {

	public static void main(String[] args) {
		PythonUtil.Process(ModelConfig.SPIDER_PY);
		PythonUtil.Process(ModelConfig.MAKE_MODEL_PY);
	}
	
}
