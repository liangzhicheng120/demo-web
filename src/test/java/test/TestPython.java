package test;

import com.xinrui.demo.util.EncryptUtil;

public class TestPython {

	public static void main(String[] args) throws Exception {
//		PythonUtil.Process(ModelConfig.SPIDER_PY);
//		PythonUtil.Process(ModelConfig.MAKE_MODEL_PY);
		System.out.println(EncryptUtil.HMACMD5("新闻"));
	}
	
}
