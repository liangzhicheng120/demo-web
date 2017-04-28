package com.xinrui.demo.exception;

import com.xinrui.demo.util.code.CodeConstants;
import com.xinrui.demo.util.code.CodeUtil;

public class CalException extends RuntimeException {

	private static final long serialVersionUID = -4126310073349890216L;

	private boolean pringStackTrace = false;

	/** 异常错误码 */
	private int errorCode;

	/**
	 * 错误信息
	 */
	private String errorMessage;

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public CalException() {
		super();
		this.errorCode = CodeConstants.SERVER_UNKNOW;
		this.errorMessage = CodeUtil.getMessageByCode(CodeConstants.SERVER_UNKNOW);
	}

	public CalException(int code, Throwable cause) {
		super(cause);
		this.errorCode = code;
		this.errorMessage = CodeUtil.getMessageByCode(code);
		this.pringStackTrace = true;
	}

	public CalException(Throwable cause) {
		super(cause);
		this.pringStackTrace = true;
	}

	public CalException(int code) {
		this.errorCode = code;
		this.errorMessage = CodeUtil.getMessageByCode(code);
	}

	/**
	 * 支持传入参数，替换错误信息中的占位符
	 * 
	 * @param code
	 * @param args
	 */
	public CalException(int code, Object... args) {
		this.errorCode = code;
		this.errorMessage = String.format(CodeUtil.getMessageByCode(code), args);
	}

	public boolean isPringStackTrace() {
		return pringStackTrace;
	}

}
