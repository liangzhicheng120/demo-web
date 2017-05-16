package com.xinrui.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinrui.demo.bean.base.BaseResultModel;
import com.xinrui.demo.service.ModelService;
import com.xinrui.demo.util.Constants;
import com.xinrui.demo.util.web.CheckUtil;
import com.xinrui.demo.util.web.SessionUtil;

@Controller
@RequestMapping(value = "/model")
public class ModelController {

	@Autowired
	private ModelService modelService;

	@RequestMapping(value = "/get")
	@ResponseBody
	public BaseResultModel get() {
		BaseResultModel baseResultModel = new BaseResultModel();
		baseResultModel.setValue(modelService.getByClzss(SessionUtil.getAttribute(Constants.CLZSS)));
		return baseResultModel;
	}

	@RequestMapping(value = "/getkeyword")
	@ResponseBody
	public BaseResultModel getKeyword(String id) {
		BaseResultModel baseResultModel = new BaseResultModel();
		baseResultModel.setValue(modelService.getById(id));
		return baseResultModel;
	}

	@RequestMapping(value = "/updatekeyword")
	@ResponseBody
	public BaseResultModel update(String id, String keyword) {
		CheckUtil.checkIsNumeric(id, "无效的ID");
		CheckUtil.checkBlank(keyword, "关键词不能为空");
		BaseResultModel baseResultModel = new BaseResultModel();
		modelService.updateKeyword(id, keyword);
		return baseResultModel;
	}
}
