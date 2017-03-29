package com.xinrui.demo.exception;

import java.io.EOFException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.xinrui.demo.util.CodeConstants;
import com.xinrui.demo.util.ErrorCodeUtil;

public class ApplicationExceptionResolver implements HandlerExceptionResolver {

	protected Logger logger = LoggerFactory.getLogger(ApplicationExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handle, Exception e) {
		Map<String, Object> model = new HashMap<String, Object>();
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		int code;
		String message;
		boolean flag = false;
		if (e instanceof BadSqlGrammarException) {
			model.put("code", CodeConstants.SQL_SYNTAX_ERROR);
			model.put("message", "sql”Ô∑®¥ÌŒÛ");
			model.put("value", "");     
			ModelAndView m = new ModelAndView("error", model);
			m.addObject("Cache-Control", "no-cache");
			m.addObject("Pragma", "no-cache");
			m.addObject("Expires", 0);
			return m;
		}
		if (e instanceof CalException) {
			CalException es = (CalException) e;
			code = es.getErrorCode();
			message = es.getErrorMessage();
			flag = es.isPringStackTrace();
		} else if (e instanceof CalInvitationException) {
			CalInvitationException es = (CalInvitationException) e;
			code = es.getErrorCode();
			message = es.getErrorMessage();
			flag = es.isPringStackTrace();
			model.put("code", code);
			model.put("message", message);
			model.put("value", "");
			ModelAndView m = new ModelAndView("error", model);
			m.addObject("Cache-Control", "no-cache");
			m.addObject("Pragma", "no-cache");
			m.addObject("Expires", 0);
			return m;
		} else {
			code = CodeConstants.SERVER_UNKNOW;
			message = ErrorCodeUtil.getMessageByCode(code);
			flag = true;
		}
		if (!EOFException.class.isInstance(e)) {
			if (flag) {
				logger.error("unexpected", e);
			}
		}
		model.put("code", code);
		model.put("message", message);
		model.put("value", "");
		ModelAndView m = new ModelAndView("error", model);
		m.addObject("Cache-Control", "no-cache");
		m.addObject("Pragma", "no-cache");
		m.addObject("Expires", 0);
		return m;

	}
}
