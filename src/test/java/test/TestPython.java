package test;

import com.xinrui.demo.util.ModelConfig;
import com.xinrui.demo.util.PythonUtil;

public class TestPython {

	public static void main(String[] args) throws Exception {
//		PythonUtil.Process(ModelConfig.BAIKE_SPIDER_PY);
		PythonUtil.Process(ModelConfig.BAYES_BAYES_PY, "新闻");
	}

}
