package com.xinrui.demo.util;

import org.apache.commons.lang.StringUtils;

public class SqlUtils {
	public static String escapeSQLLike(String input) {
		if (StringUtils.isNotEmpty(input)) {
			input = input.replace("\\", "\\\\").replace("_", "\\_").replace("%", "\\%");
		}
		return input;
	}
}
