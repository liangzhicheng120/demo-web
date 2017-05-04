package com.xinrui.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xinrui.demo.bean.Gallery;

@Repository
public interface GalleryDao {

	public List<Gallery> getAllGallery();

	public void delete(String clzss);

	public Gallery get(Map<String, Object> param);

	public void update(Gallery gallery);

	public void save(Map<String, Object> param);

}
