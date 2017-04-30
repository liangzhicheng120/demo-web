package com.xinrui.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.bean.Gallery;
import com.xinrui.demo.dao.GalleryDao;
import com.xinrui.demo.service.GalleryService;

@Service
public class GalleryServiceImpl implements GalleryService {

	@Autowired
	private GalleryDao galleryDao;

	@Transactional
	public List<Gallery> getAllGallery() {
		return galleryDao.getAllGallery();
	}

}
