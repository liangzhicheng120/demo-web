package com.xinrui.demo.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xinrui.demo.bean.Gallery;
import com.xinrui.demo.bean.base.BaseResultModel;
import com.xinrui.demo.bean.param.GalleryParam;
import com.xinrui.demo.bean.vo.GalleryVO;
import com.xinrui.demo.exception.CalException;
import com.xinrui.demo.python.PyConstants;
import com.xinrui.demo.python.PythonUtil;
import com.xinrui.demo.service.GalleryService;
import com.xinrui.demo.service.NoteService;
import com.xinrui.demo.util.code.CodeConstants;
import com.xinrui.demo.util.encrypt.EncryptUtil;
import com.xinrui.demo.util.web.CheckUtil;

@Controller
@RequestMapping(value = "/gallery")
public class GalleryController {

	@Autowired
	private NoteService noteService;
	
	@Autowired
	private GalleryService galleryService;

	@RequestMapping(value = "/init")
	@ResponseBody
	public BaseResultModel init(String clzss, String label) throws Exception {
		CheckUtil.checkBlank(clzss, "类别不能为空");
		CheckUtil.checkBlank(label, "标签不能为空");
		galleryService.save(clzss, label);
		PythonUtil.Process(PyConstants.ml.BAIKE_PY, clzss, label, EncryptUtil.HMACMD5(clzss));
		BaseResultModel baseResultModel = new BaseResultModel();
		return baseResultModel;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public BaseResultModel list() {
		System.out.println("list");
		BaseResultModel baseResultModel = new BaseResultModel();
		List<Gallery> galleries = galleryService.getAllGallery();
		List<GalleryVO> galleryVOs = new ArrayList<GalleryVO>();
		for (Gallery gallery : galleries) {
			gallery.setNum(noteService.countByClzss(gallery.getClzss()));
			galleryVOs.add(GalleryVO.build(gallery));
		}
		JSONObject value = new JSONObject();
		value.put("data", galleryVOs);
		baseResultModel.setValue(value);
		return baseResultModel;
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public BaseResultModel delete(String clzss) throws Exception {
		CheckUtil.checkBlank(clzss, "类别不能为空");
		BaseResultModel baseResultModel = new BaseResultModel();
		galleryService.delete(clzss);
		return baseResultModel;
	}

	@RequestMapping(value = "/get")
	@ResponseBody
	public BaseResultModel get(@RequestParam(required = false) String clzss, @RequestParam(required = false) String label) {
		BaseResultModel baseResultModel = new BaseResultModel();
		Gallery gallery = galleryService.get(clzss, label);
		if (gallery != null) {
			throw new CalException(CodeConstants.CLZSS_IS_EXIST, "类型已存在");
		}
		return baseResultModel;
	}

	@RequestMapping(value = "/update")
	@ResponseBody
	public BaseResultModel update(GalleryParam galleryParam) throws Exception {
		CheckUtil.checkBlank(galleryParam.getNewlabel(), "新标签不能为空");
		galleryService.update(galleryParam.transformModel());
		PythonUtil.Process(PyConstants.ml.BAIKE_PY, galleryParam.getClzss(), galleryParam.getNewlabel(), EncryptUtil.HMACMD5(galleryParam.getClzss()));
		BaseResultModel baseResultModel = new BaseResultModel();
		return baseResultModel;
	}
}
