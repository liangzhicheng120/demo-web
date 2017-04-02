package com.xinrui.demo.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.xinrui.demo.util.CodeConstants;
import com.xinrui.demo.util.CodeUtil;

public class ApplicationExceptionResolver implements HandlerExceptionResolver {

	private static Logger logger = Logger.getLogger(ApplicationExceptionResolver.class);

	@Override
	@ResponseBody
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handle, Exception e) {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		if (e instanceof IOException) {
			return makeModelAndView(CodeConstants.READ_FILE_ERROR, e);
		}
		if (e instanceof FileNotFoundException) {
			return makeModelAndView(CodeConstants.ACCESS_FILE_ERROR, e);
		}
		if (e instanceof BadSqlGrammarException) {
			return makeModelAndView(CodeConstants.SQL_SYNTAX_ERROR, e);
		}
		if (e instanceof CalException) {
			CalException es = (CalException) e;
			ModelAndView mav = new ModelAndView("error");
			mav.addObject("Cache-Control", "no-cache");
			mav.addObject("Pragma", "no-cache");
			mav.addObject("Expires", 0);
			mav.addObject("code", es.getErrorCode());
			mav.addObject("message", es.getErrorMessage());
			mav.addObject("value", "");
			return mav;
		}
		return makeModelAndView(CodeConstants.SERVER_UNKNOW, e);
	}

	public ModelAndView makeModelAndView(int code, Throwable e) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("Cache-Control", "no-cache");
		mav.addObject("Pragma", "no-cache");
		mav.addObject("Expires", 0);
		mav.addObject("code", code);
		mav.addObject("message", CodeUtil.getMessageByCode(code));
		mav.addObject("value", "");
		logger.error("ERROR INFOMATION:", e);
		return mav;
	}

}
