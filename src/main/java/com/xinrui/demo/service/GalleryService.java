package com.xinrui.demo.service;

import java.util.List;

import com.xinrui.demo.bean.Gallery;

public interface GalleryService {

	public List<Gallery> getAllGallery();

	public void delete(String clzss) throws Exception;

	public Gallery get(String clzss, String label);

	public void update(Gallery gallery);

	public void save(String clzss, String label);
}
