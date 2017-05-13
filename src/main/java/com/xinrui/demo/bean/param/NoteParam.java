package com.xinrui.demo.bean.param;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.hankcs.hanlp.HanLP;
import com.xinrui.demo.algorithm.bayes.Bayes;
import com.xinrui.demo.bean.Note;
import com.xinrui.demo.util.Constants;
import com.xinrui.demo.util.web.HtmlUtil;
import com.xinrui.demo.util.web.SessionUtil;

public class NoteParam {

	private int id;

	private String content;

	private String keyword;

	private Date posttime;

	private String title;

	private int aid;

	private String clzss;

	private String label;
	
	private String remarks;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getClzss() {
		return clzss;
	}

	public void setClzss(String clzss) {
		this.clzss = clzss;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Note transformModel() throws Exception {
		Note note = new Note();
		note.setId(this.getId());
		note.setContent(this.getContent());
		note.setKeyword((String) ObjectUtils.defaultIfNull(this.getKeyword(), HanLP.extractKeyword(HtmlUtil.delHTMLTag(this.getContent()), 3).toString().replace("[", "").replace("]", "")));
		if (StringUtils.isEmpty(this.getLabel())) {
			note.setLabel(Bayes.predictClassify(Bayes.read(SessionUtil.getAttribute(Constants.CLZSS)), (ArrayList<String>) HanLP.extractKeyword(HtmlUtil.delHTMLTag(this.getContent()), 15)));
		} else {
			note.setLabel(this.getLabel());
		}
		note.setTitle(this.getTitle());
		note.setAid(Integer.valueOf(SessionUtil.getAttribute(Constants.AID)));
		note.setPosttime(this.getPosttime());
		note.setClzss(SessionUtil.getAttribute(Constants.CLZSS));
		note.setRemarks(this.getRemarks());
		return note;
	}
}
