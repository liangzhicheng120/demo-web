package com.xinrui.demo.bean.vo;

import java.sql.Date;

import com.xinrui.demo.bean.Note;
import com.xinrui.demo.util.web.HtmlUtil;

public class NoteVO {

	private int id;

	private String content;

	private String keyword;

	private Date posttime;

	private String title;

	private int aid;

	private String nclass;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNclass() {
		return nclass;
	}

	public void setNclass(String nclass) {
		this.nclass = nclass;
	}

	public static NoteVO build(Note note) {
		NoteVO noteVO = new NoteVO();
		noteVO.setAid(note.getAid());
		noteVO.setTitle(note.getTitle());
		noteVO.setContent(HtmlUtil.delHTMLTag(note.getContent()));
		noteVO.setId(note.getId());
		noteVO.setKeyword(note.getKeyword());
		noteVO.setPosttime(note.getPosttime());
		noteVO.setNclass(note.getNclass());
		return noteVO;
	}

}
