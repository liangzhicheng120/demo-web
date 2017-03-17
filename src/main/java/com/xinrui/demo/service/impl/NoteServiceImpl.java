package com.xinrui.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.bean.Note;
import com.xinrui.demo.bean.param.PageParam;
import com.xinrui.demo.dao.NoteDao;
import com.xinrui.demo.service.NoteService;
import com.xinrui.demo.util.SqlUtils;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDao noteDao;

	@Transactional
	public List<Note> getAllByPage(String keyword, PageParam pageParam) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("keyword", SqlUtils.escapeSQLLike(keyword));
		param.put("pageParam", pageParam);
		return noteDao.getAllByPage(param);
	}

}
