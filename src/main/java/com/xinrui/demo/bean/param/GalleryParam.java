package com.xinrui.demo.bean.param;

import com.xinrui.demo.bean.Gallery;

public class GalleryParam {
	
	private int id;

	private String clzss;

	private String label;

	private String newlabel;

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

	public String getNewlabel() {
		return newlabel;
	}

	public void setNewlabel(String newlabel) {
		this.newlabel = newlabel;
	}

	public Gallery transformModel() {
		Gallery gallery = new Gallery();
		gallery.setId(this.getId());
		gallery.setClzss(this.getClzss());
		gallery.setLabel(this.getLabel() + "," + this.getNewlabel());
		return gallery;
	}

}
