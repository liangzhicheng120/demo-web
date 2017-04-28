package com.xinrui.demo.bean.base;

public class BaseResultModel {

	private int code = 200;

	private String message = "";

	private Object value;

	private String redirect = "";

	public BaseResultModel() {
	}

	public BaseResultModel(Object value) {
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

}