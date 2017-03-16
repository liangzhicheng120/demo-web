package com.xinrui.demo.bean.vo;

import java.sql.Date;

import com.xinrui.demo.bean.Note;

public class NoteVO {

	private int id;

	private String content;

	private String keyword;

	private Date posttime;

	private int aid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static NoteVO build(Note note) {
		NoteVO noteVO = new NoteVO();
		noteVO.setAid(note.getAid());
		noteVO.setContent(note.getContent());
		noteVO.setId(note.getId());
		noteVO.setKeyword(note.getKeyword());
		noteVO.setPosttime(note.getPosttime());
		return noteVO;
	}

}
