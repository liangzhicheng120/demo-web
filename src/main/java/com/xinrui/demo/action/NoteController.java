package com.xinrui.demo.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xinrui.demo.bean.BaseResultModel;
import com.xinrui.demo.bean.Note;
import com.xinrui.demo.bean.param.PageParam;
import com.xinrui.demo.bean.vo.NoteVO;
import com.xinrui.demo.service.NoteService;
import com.xinrui.demo.util.CheckUtil;
import com.xinrui.demo.util.StringUtil;

@Controller
@RequestMapping(value = "/note")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@RequestMapping(value = "/list")
	@ResponseBody
	public BaseResultModel list(@RequestParam(required = false) String keyword, String currentPage) {
		BaseResultModel baseResultModel = new BaseResultModel();
		PageParam pageParam = new PageParam(currentPage);
		List<Note> notes = noteService.getAllByPage(keyword, pageParam);
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
	public BaseResultModel delete(int id) {
		CheckUtil.checkLeZero(id, "无效的ID");
		BaseResultModel baseResultModel = new BaseResultModel();
		noteService.delete(id);
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
}
