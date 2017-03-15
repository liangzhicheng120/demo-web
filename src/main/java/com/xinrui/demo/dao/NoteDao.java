package com.xinrui.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xinrui.demo.bean.Note;

@Repository
public interface NoteDao {
	public List<Note> getAll();
}
