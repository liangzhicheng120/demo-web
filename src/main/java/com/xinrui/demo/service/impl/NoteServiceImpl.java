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
import com.xinrui.demo.util.Constants;
import com.xinrui.demo.util.sql.SqlUtils;
import com.xinrui.demo.util.web.SessionUtil;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDao noteDao;

	@Transactional
	public List<Note> getAllByPage(String label, String keyword, PageParam pageParam, String start, String end) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("clzss", SessionUtil.getAttribute(Constants.CLZSS));
		param.put("aid", SessionUtil.getAttribute(Constants.AID));
		param.put("label", label);
		param.put("keyword", SqlUtils.escapeSQLLike(keyword));
		param.put("pageParam", pageParam);
		param.put("start", start);
		param.put("end", end);
		return noteDao.getAllByPage(param);
	}

	@Transactional
	public void delete(int id) {
		Note note = new Note();
		note.setId(id);
		noteDao.delete(note);
	}

	@Transactional
	public void batchDelete(List<Integer> ids) {
		noteDao.batchDelete(ids);
	}

	@Transactional
	public void save(Note note) {
		noteDao.save(note);
	}

	@Transactional
	public Note get(int id) {
		return noteDao.get(id);
	}

	@Transactional
	public void update(Note note) {
		noteDao.update(note);
	}

	@Transactional
	public void deleteByClzss(String clzss) {
		noteDao.deleteByClzss(clzss);
	}

}
