package com.xinrui.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xinrui.demo.bean.Gallery;

@Repository
public interface GalleryDao {
	public List<Gallery> getAllGallery();
}
