package test;

import com.xinrui.demo.python.PyConstants;
import com.xinrui.demo.python.PythonUtil;
import com.xinrui.demo.util.encrypt.EncryptUtil;

public class TestPython {

	public static void main(String[] args) throws Exception {
		PythonUtil.Process(PyConstants.SPIDER_PY, EncryptUtil.HMACMD5("学习"));
	}

}
