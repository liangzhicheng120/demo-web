package com.xinrui.demo.bean.param;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.commons.lang.ObjectUtils;

import com.hankcs.hanlp.HanLP;
import com.xinrui.demo.bean.Note;
import com.xinrui.demo.ml.Bayes;
import com.xinrui.demo.util.Constants;
import com.xinrui.demo.util.HtmlUtil;
import com.xinrui.demo.util.SessionUtil;

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

	public Note transformModel() throws Exception {
		Note note = new Note();
		note.setId(this.getId());
		note.setContent(this.getContent());
		note.setKeyword((String) ObjectUtils.defaultIfNull(this.getKeyword(),
				HanLP.extractKeyword(HtmlUtil.delHTMLTag(this.getContent()), 3).toString().replace("[", "").replace("]", "")));
		note.setNclass((String) ObjectUtils.defaultIfNull(this.getNclass(),
				Bayes.predictClassify(Bayes.read("新闻"), (ArrayList<String>) HanLP.extractKeyword(HtmlUtil.delHTMLTag(this.getContent()), 15))));
		note.setTitle(this.getTitle());
		note.setAid(Integer.valueOf(SessionUtil.getAttribute(Constants.AID)));
		note.setPosttime(this.getPosttime());
		return note;
	}

}
