package com.xinrui.demo.action.interceptor;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xinrui.demo.util.Constants;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private Set<String> excludeUrl;

	private Set<String> includeUrl;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean flag = false;
		String url = request.getRequestURI().toString();
		String loginUrl = request.getSession().getServletContext().getContextPath() + "/";
		if (url.endsWith(loginUrl)) {
			return true;
		}
		flag = is_include(excludeUrl, url);
		if (!flag) {
			String admin = (String) request.getSession().getAttribute(Constants.ADMIN);
			if (admin != null) {
				flag = true;
			} else {
				response.sendRedirect("login");
			}
		}
		return flag;

	}

	private boolean is_include(Set<String> sets, String url) {
		boolean is_include = false;
		if (CollectionUtils.isNotEmpty(sets)) {
			for (String s : sets) {
				if (url.contains(s)) {
					is_include = true;
					break;
				}
			}
		}
		return is_include;
	}

	public Set<String> getExcludeUrl() {

		return excludeUrl;
	}

	public void setExcludeUrl(Set<String> excludeUrl) {

		this.excludeUrl = excludeUrl;
	}

	public Set<String> getIncludeUrl() {

		return includeUrl;
	}

	public void setIncludeUrl(Set<String> includeUrl) {

		this.includeUrl = includeUrl;
	}

}
