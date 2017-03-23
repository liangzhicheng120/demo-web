package com.xinrui.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hankcs.hanlp.HanLP;
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
	public List<Note> getAllByPage(String keyword, String nclass, PageParam pageParam) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("keyword", SqlUtils.escapeSQLLike(keyword));
		param.put("nclass", nclass);
		param.put("pageParam", pageParam);
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
	public void save(String tiitle, String content) {
		Note note = new Note();
		note.setAid(1);
		note.setContent(content);
		List<String> keywords = HanLP.extractKeyword(content, 3);
		note.setKeyword(keywords.toString().replace("[", "").replace("]", ""));
		note.setTitle(tiitle);
		note.setNclass("IT"); 	//DOTO 未实现分类
		noteDao.save(note);
	}

}
