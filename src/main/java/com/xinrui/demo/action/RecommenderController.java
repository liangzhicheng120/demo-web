package com.xinrui.demo.action;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinrui.demo.bean.base.BaseResultModel;
import com.xinrui.demo.service.RecommenderService;
import com.xinrui.demo.util.web.CheckUtil;

@Controller
@RequestMapping(value = "/recommend")
public class RecommenderController {

	@Autowired
	private RecommenderService recommenderService;

	@RequestMapping(value = "/usercf")
	@ResponseBody
	public BaseResultModel userCf(String uid) {
		CheckUtil.checkIsNumeric(uid, "uid非法");
		BaseResultModel baseResultModel = new BaseResultModel();
		List<RecommendedItem> recommendations = recommenderService.userBaseRecommend(Integer.valueOf(uid));
		baseResultModel.setValue(recommendations);
		return baseResultModel;
	}
}
