package com.xinrui.demo.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xinrui.demo.bean.Note;
import com.xinrui.demo.bean.base.BaseResultModel;
import com.xinrui.demo.bean.param.NoteParam;
import com.xinrui.demo.bean.param.PageParam;
import com.xinrui.demo.bean.vo.NoteVO;
import com.xinrui.demo.python.PyConstants;
import com.xinrui.demo.python.PythonUtil;
import com.xinrui.demo.service.NoteService;
import com.xinrui.demo.util.StringUtil;
import com.xinrui.demo.util.web.CheckUtil;
import com.xinrui.demo.util.web.Nclass;

@Controller
@RequestMapping(value = "/note")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@RequestMapping(value = "/list")
	@ResponseBody
	public BaseResultModel list(@RequestParam(required = false) String keyword, @RequestParam(required = false) String nclass, String currentPage,
			@RequestParam(required = false) String start, @RequestParam(required = false) String end) {
		BaseResultModel baseResultModel = new BaseResultModel();
		PageParam pageParam = new PageParam(currentPage);
		List<Note> notes = noteService.getAllByPage(keyword, nclass, pageParam, start, end);
		List<NoteVO> noteVOs = new ArrayList<NoteVO>();
		for (Note note : notes) {
			noteVOs.add(NoteVO.build(note));
		}
		JSONObject value = new JSONObject();
		value.put("data", noteVOs);
		value.put("pageParam", pageParam);
		baseResultModel.setValue(value);
		return baseResultModel;
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public BaseResultModel delete(String id) {
		CheckUtil.checkIsNumeric(id, "无效的ID");
		BaseResultModel baseResultModel = new BaseResultModel();
		noteService.delete(Integer.valueOf(id));
		return baseResultModel;
	}

	@RequestMapping(value = "/batchdelete")
	@ResponseBody
	public BaseResultModel batchdelete(String ids) {
		CheckUtil.checkBlank(ids, "无效的ID");
		BaseResultModel baseResultModel = new BaseResultModel();
		noteService.batchDelete(StringUtil.fromStringToInteger(ids.split(",")));
		return baseResultModel;
	}

	@RequestMapping(value = "/getnclass")
	@ResponseBody
	public BaseResultModel getNclass() {
		BaseResultModel baseResultModel = new BaseResultModel();
		List<JSONObject> value = new ArrayList<JSONObject>();
		for (Nclass nc : Nclass.values()) {
			JSONObject e = new JSONObject();
			e.put("typeCode", nc.getTypeCode());
			e.put("desc", nc.getDesc());
			value.add(e);
		}
		baseResultModel.setValue(value);
		return baseResultModel;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public BaseResultModel save(NoteParam noteParam) throws Exception {
		CheckUtil.checkBlank(noteParam.getTitle(), "标题不能为空");
		CheckUtil.checkBlank(noteParam.getContent(), "内容不能为空");
		BaseResultModel baseResultModel = new BaseResultModel();
		noteService.save(noteParam.transformModel());
		return baseResultModel;
	}

	@RequestMapping(value = "/get")
	@ResponseBody
	public BaseResultModel get(String id) {
		CheckUtil.checkIsNumeric(id, "id不能为空");
		BaseResultModel baseResultModel = new BaseResultModel();
		baseResultModel.setValue(noteService.get(Integer.valueOf(id)));
		return baseResultModel;
	}

	@RequestMapping(value = "/update")
	@ResponseBody
	public BaseResultModel update(NoteParam noteParam) throws Exception {
		CheckUtil.checkBlank(noteParam.getTitle(), "标题不能为空");
		CheckUtil.checkBlank(noteParam.getContent(), "内容不能为空");
		BaseResultModel baseResultModel = new BaseResultModel();
		noteService.update(noteParam.transformModel());
		return baseResultModel;
	}

	@RequestMapping(value = "/initmodel")
	@ResponseBody
	public BaseResultModel initModel(String clzss, String label) {
		CheckUtil.checkBlank(clzss, "类别不能为空");
		CheckUtil.checkBlank(label, "标签不能为空");
		PythonUtil.Process(PyConstants.ml.SPIDER_PY, clzss);
		BaseResultModel baseResultModel = new BaseResultModel();
		return baseResultModel;
	}

}
