package com.xinrui.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinrui.demo.bean.Gallery;
import com.xinrui.demo.dao.GalleryDao;
import com.xinrui.demo.dao.ModelDao;
import com.xinrui.demo.dao.NoteDao;
import com.xinrui.demo.service.GalleryService;
import com.xinrui.demo.util.file.FileUtil;
import com.xinrui.demo.util.sql.SqlUtils;

@Service
public class GalleryServiceImpl implements GalleryService {

	@Autowired
	private GalleryDao galleryDao;

	@Autowired
	private NoteDao noteDao;

	@Autowired
	private ModelDao modelDao;

	@Transactional
	public List<Gallery> getAllGallery() {
		return galleryDao.getAllGallery();
	}

	@Transactional
	public void delete(String clzss) throws Exception {
		galleryDao.delete(clzss);
		noteDao.deleteByClzss(clzss);
		modelDao.delete(clzss);
		FileUtil.deleteModelFile(clzss);
	}

	@Transactional
	public Gallery get(String clzss, String label) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("clzss", clzss);
		param.put("label", SqlUtils.escapeSQLLike(label));
		return galleryDao.get(param);
	}

	@Transactional
	public void update(Gallery gallery) {
		galleryDao.update(gallery);
	}

	@Transactional
	public void save(String clzss, String label) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("clzss", clzss);
		param.put("label", SqlUtils.escapeSQLLike(label));
		galleryDao.save(param);
	}

}
