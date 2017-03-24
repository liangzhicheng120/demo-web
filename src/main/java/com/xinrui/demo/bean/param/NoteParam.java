package com.xinrui.demo.bean.param;

import java.sql.Date;

import com.hankcs.hanlp.HanLP;
import com.xinrui.demo.bean.Note;
import com.xinrui.demo.util.HtmlUtil;

public class NoteParam {
	private int id;

	private String content;

	private String keyword;

	private Date posttime;

	private String title;

	private int aid;

	private String nclass;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Note transformModel() {
		Note note = new Note();
		note.setId(this.getId());
		note.setContent(this.getContent());
		note.setKeyword(HanLP.extractKeyword(HtmlUtil.delHTMLTag(content), 3).toString().replace("[", "").replace("]", ""));
		note.setNclass(this.getNclass());
		note.setTitle(this.getTitle());
		note.setAid(this.getAid());
		note.setPosttime(this.getPosttime());
		return note;

	}
}