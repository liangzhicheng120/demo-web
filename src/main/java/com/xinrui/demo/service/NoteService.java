package com.xinrui.demo.service;

import java.util.List;

import com.xinrui.demo.bean.Note;
import com.xinrui.demo.bean.param.PageParam;

public interface NoteService {

	public List<Note> getAllByPage(String label, String keyword, PageParam pageParam, String start, String end);

	public void delete(int id);

	public void batchDelete(List<Integer> ids);

	public void save(Note note);

	public Note get(int id);

	public void update(Note note);
	
	public void deleteByClzss(String clzss);
}
