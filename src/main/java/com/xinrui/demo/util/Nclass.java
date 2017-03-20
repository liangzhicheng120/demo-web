package com.xinrui.demo.util;

import java.util.HashMap;
import java.util.Map;

public enum Nclass {
	
	IT(0, "IT"), EDUCATION(1, "教育"), FINANCE(2, "财经"), SPORTS(3, "体育");

	private int typeCode;

	private String desc;

	private static Map<Integer, Nclass> typeCodeCache = new HashMap<Integer, Nclass>();

	static {
		for (Nclass nclass : Nclass.values()) {
			typeCodeCache.put(nclass.getTypeCode(), nclass);
		}
	}

	private Nclass(int typeCode, String desc) {
		this.typeCode = typeCode;
		this.desc = desc;
	}

	public int getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static Nclass from(int source) {
		return typeCodeCache.get(source);
	}

}
