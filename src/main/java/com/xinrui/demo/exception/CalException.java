/**
 * 
 */
package com.xinrui.demo.exception;

import com.xinrui.demo.util.ErrorCodeUtil;

public class CalException extends RuntimeException {

	private static final long serialVersionUID = -4126310073349890216L;

	private boolean pringStackTrace = false;

	/** �쳣������ */
	private int errorCode;

	/**
	 * ������Ϣ
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
		this.errorMessage = ErrorCodeUtil
				.getMessageByCode(CodeConstants.SERVER_UNKNOW);
	}

	public CalException(int code, Throwable cause) {
		super(cause);
		this.errorCode = code;
		this.errorMessage = ErrorCodeUtil.getMessageByCode(code);
		this.pringStackTrace = true;
	}

	public CalException(Throwable cause) {
		super(cause);
		this.pringStackTrace = true;
	}

	public CalException(int code) {
		this.errorCode = code;
		this.errorMessage = ErrorCodeUtil.getMessageByCode(code);
	}

	/**
	 * ֧�ִ���������滻������Ϣ�е�ռλ��
	 * 
	 * @param code
	 * @param args
	 */
	public CalException(int code, Object... args) {
		this.errorCode = code;
		this.errorMessage = String.format(ErrorCodeUtil.getMessageByCode(code),
				args);
	}

	public boolean isPringStackTrace() {
		return pringStackTrace;
	}

}
