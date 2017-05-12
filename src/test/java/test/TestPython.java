package test;

import com.xinrui.demo.python.PyConstants;
import com.xinrui.demo.python.PythonUtil;
import com.xinrui.demo.util.encrypt.EncryptUtil;

public class TestPython {

	public static void main(String[] args) throws Exception {
		// PythonUtil.run(PyConstants.ml.BAIKE_PY, "学习", "语文,数学,英语",
		// EncryptUtil.HMACMD5("学习"));
		// PythonUtil.run(PyConstants.ml.BAYES_PY,EncryptUtil.HMACMD5("学习"));
		// System.out.println(EncryptUtil.HMACMD5("佛教"));
		// PythonUtil.run(PyConstants.ml.BAYES_PY, EncryptUtil.HMACMD5("编程"));
		 PythonUtil.run(PyConstants.ml.RECOMMEND_PY);
	}
}
