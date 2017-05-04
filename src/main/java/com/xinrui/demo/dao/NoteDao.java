package com.xinrui.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xinrui.demo.bean.Note;

@Repository
public interface NoteDao {

	public List<Note> getAllByPage(Map<String, Object> parameter);

	public void delete(Note note);

	public void batchDelete(List<Integer> ids);

	public void save(Note note);

	public Note get(int id);

	public void update(Note note);

	public void deleteByClzss(String clzss);

}
