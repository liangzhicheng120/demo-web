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
import com.xinrui.demo.service.NoteService;
import com.xinrui.demo.util.Constants;
import com.xinrui.demo.util.StringUtil;
import com.xinrui.demo.util.web.CheckUtil;
import com.xinrui.demo.util.web.SessionUtil;

@Controller
@RequestMapping(value = "/note")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@RequestMapping(value = "/list")
	@ResponseBody
	public BaseResultModel list(@RequestParam(required = false) String label, @RequestParam(required = false) String keyword, String currentPage, @RequestParam(required = false) String start,
			@RequestParam(required = false) String end) {
		BaseResultModel baseResultModel = new BaseResultModel();
		PageParam pageParam = new PageParam(currentPage);
		List<Note> notes = noteService.getAllByPage(label, keyword, pageParam, start, end);
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

	@RequestMapping(value = "/getlabel")
	@ResponseBody
	public BaseResultModel getLabel() {
		BaseResultModel baseResultModel = new BaseResultModel();
		JSONObject label = new JSONObject();
		label.put("label", SessionUtil.getAttribute(Constants.LABEL));
		baseResultModel.setValue(label);
		return baseResultModel;
	}

}
