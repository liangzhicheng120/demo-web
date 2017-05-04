package com.xinrui.demo.util.file;

import java.io.File;

import com.xinrui.demo.python.PyConstants;
import com.xinrui.demo.util.encrypt.EncryptUtil;

public class FileUtil {
	public static void deleteModelFile(String fileName) throws Exception {
		File file = new File(PyConstants.ml.BAYES_MODEL + EncryptUtil.HMACMD5(fileName) + ".txt");
		if (file.isFile() && file.exists()) {
			file.delete();
		}
	}
}
