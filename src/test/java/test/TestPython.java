package test;

import com.xinrui.demo.python.PyConstants;
import com.xinrui.demo.python.PythonUtil;
import com.xinrui.demo.util.encrypt.EncryptUtil;

public class TestPython {

	public static void main(String[] args) throws Exception {
//		PythonUtil.Process(PyConstants.ml.BAIKE_PY, "学习", "语文,数学,英语", EncryptUtil.HMACMD5("学习"));
		PythonUtil.Process(PyConstants.ml.BAYES_PY,EncryptUtil.HMACMD5("学习"));
	}

}
