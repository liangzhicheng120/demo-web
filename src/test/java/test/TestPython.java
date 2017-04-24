package test;

import com.xinrui.demo.util.EncryptUtil;
import com.xinrui.demo.util.ModelConfig;
import com.xinrui.demo.util.PythonUtil;

public class TestPython {

	public static void main(String[] args) throws Exception {
		// PythonUtil.winProcess(ModelConfig.BAIKE_SPIDER_PY);
		PythonUtil.winProcess(ModelConfig.BAYES_BAYES_PY, EncryptUtil.HMACMD5("新闻"));
		// System.out.println(EncryptUtil.HMACMD5("学习"));
	}

}
