package com.xinrui.demo.exception;

import com.xinrui.demo.util.ErrorCodeUtil;

public class CalInvitationException extends RuntimeException {

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = -1385275556608557209L;

	/** 异常错误码 */
	private int errorCode;

	private boolean pringStackTrace = false;

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

	public CalInvitationException() {
		super();
		this.errorCode = CodeConstants.SERVER_UNKNOW;
		this.errorMessage = ErrorCodeUtil
				.getMessageByCode(CodeConstants.SERVER_UNKNOW);
	}

	public CalInvitationException(int code, Throwable cause) {
		super(cause);
		this.errorCode = code;
		this.errorMessage = ErrorCodeUtil.getMessageByCode(code);
		this.pringStackTrace = true;
	}

	public CalInvitationException(Throwable cause) {
		super(cause);
		this.pringStackTrace = true;
	}

	public CalInvitationException(int code) {
		this.errorCode = code;
		this.errorMessage = ErrorCodeUtil.getMessageByCode(code);
	}

	/**
	 * 支持传入参数，替换错误信息中的占位符
	 * 
	 * @param code
	 * @param args
	 */
	public CalInvitationException(int code, Object... args) {
		this.errorCode = code;
		this.errorMessage = String.format(ErrorCodeUtil.getMessageByCode(code),
				args);
	}

	public boolean isPringStackTrace() {
		return pringStackTrace;
	}

}
