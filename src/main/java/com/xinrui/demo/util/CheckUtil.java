package com.xinrui.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.xinrui.demo.exception.CalException;

public class CheckUtil {

	public static void isValidUrl(String url) {
		if (StringUtils.isBlank(url)) {
			return;
		}
		String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		Pattern patt = Pattern.compile(regex);
		Matcher matcher = patt.matcher(url);
		boolean isMatch = matcher.matches();
		if (!isMatch) {
			throw new CalException(CodeConstants.PARAMETERS_CHECK_ERROR,
					"URL地址:[" + url + "]不合法");
		}

	}

	public static void isValiLength(String str, int length) {
		if (StringUtils.isBlank(str)) {
			throw new CalException(CodeConstants.PARAMETERS_CHECK_ERROR,
					"参数不能为空");
		}
		if (str.trim().length() > length) {
			throw new CalException(CodeConstants.PARAMETERS_CHECK_ERROR,
					"参数长度不能超过[" + length + "]个字符");
		}
	}

	public static void checkBlank(String str, String errMsg) {
		if (StringUtils.isBlank(str)) {
			throw new CalException(CodeConstants.PARAMETERS_CHECK_ERROR, errMsg);
		}
	}

	public static void isValidUnPushRegister(String sign, String serverSign) {
		if (!sign.equals(serverSign)) {
			throw new CalException(CodeConstants.PARAMETERS_CHECK_ERROR,
					"客户端sign[" + sign + "[不合法");
		}

	}

	public static void checkLeZero(Integer num, Object... args) {
		if (num == null || num <= 0) {
			throw new CalException(CodeConstants.PARAMETERS_CHECK_ERROR, args);
		}
	}
	
	public static void checkObjIsEqual(Object obj1,Object obj2,Object... args) {
		if (obj1 != obj2) {
			throw new CalException(CodeConstants.PARAMETERS_CHECK_ERROR, args);
		}
	}
	
}
