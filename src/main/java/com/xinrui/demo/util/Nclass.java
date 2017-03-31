package com.xinrui.demo.util;

import java.util.HashMap;
import java.util.Map;

public enum Nclass {

	SPORTS(0, "体育"), 
	HOUSE(1, "房产"), 
	EDUCATION(2, "教育"), 
	ENTERTAINMENT(3, "娱乐"), 
	TOUR(4, "旅游"), 
	CAR(5, "汽车"), 
	Other(6, "其他");

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
