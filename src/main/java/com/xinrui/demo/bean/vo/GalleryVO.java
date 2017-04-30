package com.xinrui.demo.bean.vo;

import com.xinrui.demo.bean.Gallery;

public class GalleryVO {

	private int id;

	private String clzss;

	private String label;

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

	public static GalleryVO build(Gallery gallery) {
		GalleryVO galleryVO = new GalleryVO();
		galleryVO.setId(gallery.getId());
		galleryVO.setClzss(gallery.getClzss());
		galleryVO.setLabel(gallery.getLabel());
		return galleryVO;
	}
}
