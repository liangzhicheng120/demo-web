package com.xinrui.demo.action;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinrui.demo.bean.base.BaseResultModel;
import com.xinrui.demo.bean.param.RecommendParam;
import com.xinrui.demo.service.RecommendService;
import com.xinrui.demo.util.web.CheckUtil;

@Controller
@RequestMapping(value = "/recommend")
public class RecommendController {

	@Autowired
	private RecommendService recommendService;

	@RequestMapping(value = "/usercf")
	@ResponseBody
	public BaseResultModel userCf(String uid) {
		CheckUtil.checkIsNumeric(uid, "uid非法");
		BaseResultModel baseResultModel = new BaseResultModel();
		List<RecommendedItem> recommendations = recommendService.userBaseRecommend(Integer.valueOf(uid));
		baseResultModel.setValue(recommendations);
		return baseResultModel;
	}

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
