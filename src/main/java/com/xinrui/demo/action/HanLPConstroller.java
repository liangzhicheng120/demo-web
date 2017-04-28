package com.xinrui.demo.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hankcs.hanlp.HanLP;
import com.xinrui.demo.bean.base.BaseResultModel;

@Controller
@RequestMapping(value = "/hanlp")
public class HanLPConstroller {

	@RequestMapping(value = "/extractKeyword")
	@ResponseBody
	public BaseResultModel extractKeyword(String document, int size) {
		BaseResultModel baseResultModel = new BaseResultModel();
		List<String> keys = HanLP.extractKeyword(document, size);
		List<JSONObject> value = new ArrayList<JSONObject>();
		for (String key : keys) {
			JSONObject e = new JSONObject();
			e.put("key", key);
			value.add(e);
		}
		baseResultModel.setValue(value);
		return baseResultModel;
	}

}
