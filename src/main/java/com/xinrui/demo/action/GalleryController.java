package com.xinrui.demo.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xinrui.demo.bean.Gallery;
import com.xinrui.demo.bean.base.BaseResultModel;
import com.xinrui.demo.bean.vo.GalleryVO;
import com.xinrui.demo.service.GalleryService;

@Controller
@RequestMapping(value = "/gallery")
public class GalleryController {

	@Autowired
	private GalleryService galleryService;

	@RequestMapping(value = "/list")
	@ResponseBody
	public BaseResultModel list() {
		BaseResultModel baseResultModel = new BaseResultModel();
		List<Gallery> galleries = galleryService.getAllGallery();
		List<GalleryVO> galleryVOs = new ArrayList<GalleryVO>();
		for (Gallery gallery : galleries) {
			galleryVOs.add(GalleryVO.build(gallery));
		}
		JSONObject value = new JSONObject();
		value.put("data", galleryVOs);
		baseResultModel.setValue(value);
		return baseResultModel;
	}
}
