package com.xinrui.demo.service;

import java.util.List;

public interface HanlpService {
	/**
	 * ��ȡ�ؼ���
	 * 
	 * @param document ��ȡ���ĵ�
	 * @param size ��ȡ�Ĺؼ��ʸ���
	 * @return
	 */
	public List<String> extractKeyword(String document, int size);
}
