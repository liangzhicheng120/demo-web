package com.xinrui.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.bean.Note;
import com.xinrui.demo.bean.Recommend;
import com.xinrui.demo.bean.param.PageParam;
import com.xinrui.demo.bean.param.RecommendParam;
import com.xinrui.demo.dao.NoteDao;
import com.xinrui.demo.dao.RecommendDao;
import com.xinrui.demo.python.PyConstants;
import com.xinrui.demo.python.PythonUtil;
import com.xinrui.demo.service.NoteService;
import com.xinrui.demo.util.Constants;
import com.xinrui.demo.util.sql.SqlUtils;
import com.xinrui.demo.util.web.SessionUtil;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDao noteDao;

	@Autowired
	private RecommendDao recommendDao;

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
		Recommend recommend = new Recommend();
		note.setId(id);
		recommend.setNid(id);
		noteDao.delete(note);
		recommendDao.delete(recommend);
	}

	@Transactional
	public void batchDelete(List<Integer> ids) {
		noteDao.batchDelete(ids);
	}

	@Transactional
	public void save(Note note) {
		noteDao.save(note);
		recommendDao.save(RecommendParam.transformModel(note));
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

	@Transactional
	public int countByClzss(String clzss) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("clzss", clzss);
		return noteDao.countByClzss(param);
	}

	@Transactional
	public List<Note> recommendList() {
		List<Note> notes = new ArrayList<Note>();
		String nids = PythonUtil.run(PyConstants.ml.DEFAULT_PY, SessionUtil.getAttribute(Constants.AID));
		for (String id : StringUtils.split(nids, ",")) {
			notes.add(noteDao.get(Integer.valueOf(id)));
		}
		return notes;
	}

}
