package com.xinrui.demo.service;

import java.util.List;

import com.xinrui.demo.bean.Note;
import com.xinrui.demo.bean.param.PageParam;

public interface NoteService {
	public List<Note> getAllByPage(String keyword, String nclass, PageParam pageParam);

	public void delete(int id);

	public void batchDelete(List<Integer> ids);
}
