package com.xinrui.demo.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xinrui.demo.bean.BaseResultModel;
import com.xinrui.demo.bean.Note;
import com.xinrui.demo.bean.vo.NoteVO;
import com.xinrui.demo.service.NoteService;

@Controller
@RequestMapping(value = "/note")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@RequestMapping(value = "/list")
	@ResponseBody
	public BaseResultModel list() {
		BaseResultModel baseResultModel = new BaseResultModel();
		List<Note> notes = noteService.getAll();
		List<NoteVO> noteVOs = new ArrayList<NoteVO>();
		for (Note note : notes) {
			noteVOs.add(NoteVO.build(note));
		}
		JSONObject value = new JSONObject();
		value.put("data", noteVOs);
		baseResultModel.setValue(value);
		return baseResultModel;
	}

}
