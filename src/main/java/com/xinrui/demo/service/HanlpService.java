package com.xinrui.demo.service;

import java.util.List;

public interface HanlpService {
	/**
	 * 抽取关键词
	 * 
	 * @param document 抽取的文档
	 * @param size 提取的关键词个数
	 * @return
	 */
	public List<String> extractKeyword(String document, int size);
}
