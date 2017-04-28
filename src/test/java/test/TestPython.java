package test;

import com.xinrui.demo.python.ModelConfig;
import com.xinrui.demo.python.PythonUtil;
import com.xinrui.demo.util.EncryptUtil;

public class TestPython {

	public static void main(String[] args) throws Exception {
		// PythonUtil.winProcess(ModelConfig.BAIKE_SPIDER_PY);
		PythonUtil.Process(ModelConfig.BAIKE_SPIDER_PY, EncryptUtil.HMACMD5("学习"));
	}

}
