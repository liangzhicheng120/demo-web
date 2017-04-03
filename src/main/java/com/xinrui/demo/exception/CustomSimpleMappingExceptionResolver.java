package com.xinrui.demo.exception;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 处理ajax异常
 * 
 * @author liangzhicheng
 *
 */
public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

	private static Logger logger = Logger.getLogger(CustomSimpleMappingExceptionResolver.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		// 判断是否 Ajax请求
		if ((request.getHeader("accept").indexOf("application/json") > -1 || (request.getHeader("X-Requested-With") != null && request.getHeader(
				"X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
			try {
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter writer = response.getWriter();
				writer.write(ex.getMessage());
				writer.flush();
				writer.close();
			} catch (Exception e) {
				logger.error("处理ajax异常错误:", e);
			}
			return null;
		}

		return super.doResolveException(request, response, handler, ex);
	}
}
