package com.xinrui.demo.service.impl;

import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.xinrui.demo.service.HanlpService;

public class HanlpServiceImpl implements HanlpService{

	@Override
	public List<String> extractKeyword(String document, int size) {
		return HanLP.extractKeyword(document, size);
	}

}
