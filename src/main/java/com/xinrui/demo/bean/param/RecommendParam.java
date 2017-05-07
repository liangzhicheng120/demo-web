package com.xinrui.demo.bean.param;

import com.xinrui.demo.bean.Note;
import com.xinrui.demo.bean.Recommend;
import com.xinrui.demo.util.Constants;
import com.xinrui.demo.util.web.SessionUtil;

public class RecommendParam {

	private int id;

	private String clzss;

	private String label;

	private String nid;

	private String cost;

	private String views;

	private String aid;

	public int getId() {
		return id;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public static Recommend transformModel(Note note) {
		Recommend recommend = new Recommend();
		recommend.setClzss(note.getClzss());
		recommend.setLabel(note.getLabel());
		recommend.setNid(note.getId());
		recommend.setAid(note.getAid());
		return recommend;
	}

	public Recommend transformModel() {
		Recommend recommend = new Recommend();
		recommend.setAid(Integer.valueOf(SessionUtil.getAttribute(Constants.AID)));
		recommend.setCost(Double.valueOf(this.getCost()));
		recommend.setNid(Integer.valueOf(this.getNid()));
		return recommend;
	}
}
