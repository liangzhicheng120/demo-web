package com.xinrui.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinrui.demo.bean.base.BaseResultModel;
import com.xinrui.demo.bean.param.RecommendParam;
import com.xinrui.demo.service.NoteService;
import com.xinrui.demo.service.RecommendService;
import com.xinrui.demo.util.web.CheckUtil;

@Controller
@RequestMapping(value = "/recommend")
public class RecommendController {

	@Autowired
	private RecommendService recommendService;
	
	@Autowired
	private NoteService noteService;

	@RequestMapping(value = "/record")
	@ResponseBody
	public BaseResultModel record(RecommendParam recommendParam) {
		CheckUtil.checkBlank(recommendParam.getNid(), "nid不能为空");
		CheckUtil.checkBlank(recommendParam.getCost(), "cost不能为空");
		BaseResultModel baseResultModel = new BaseResultModel();
		recommendService.update(recommendParam.transformModel());
		return baseResultModel;
	}

}
