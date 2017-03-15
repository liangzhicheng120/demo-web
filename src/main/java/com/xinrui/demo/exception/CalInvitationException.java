package com.xinrui.demo.exception;

import com.xinrui.demo.util.ErrorCodeUtil;

public class CalInvitationException extends RuntimeException {

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = -1385275556608557209L;

	/** �쳣������ */
	private int errorCode;

	private boolean pringStackTrace = false;

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
	 * ֧�ִ���������滻������Ϣ�е�ռλ��
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
