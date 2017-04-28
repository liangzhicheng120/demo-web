package com.xinrui.demo.util.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 获取session工具
 * 
 * @author liangzhicheng
 *
 */
public class SessionUtil {
	public static String getAttribute(String name) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String attribute = (String) request.getSession().getAttribute(name);
		return attribute;
	}
}
