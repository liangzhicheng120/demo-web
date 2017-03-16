package com.xinrui.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.bean.Note;
import com.xinrui.demo.dao.NoteDao;
import com.xinrui.demo.service.NoteService;
@Service
public class NoteServiceImpl implements NoteService{
	
	@Autowired
	private NoteDao noteDao;
	
	@Transactional
	public List<Note> getAll() {
		return noteDao.getAll();
	}

}
