package com.xinrui.demo.bean.param;

import com.xinrui.demo.bean.Note;
import com.xinrui.demo.bean.Recommend;

public class RecommendParam {
	private int id;

	private String clzss;

	private String label;

	private int nid;

	private int read;

	private int time;

	private int aid;

	public int getId() {
		return id;
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

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
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
}
