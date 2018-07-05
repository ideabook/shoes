package com.xxzx.service.impl;

import java.util.List;

import com.xxzx.dao.FileuploadDao;
import com.xxzx.entity.Fileinfo;
import com.xxzx.service.FileuploadService;

public class FileuploadServiceImpl implements FileuploadService {
	private FileuploadDao fileuploadDao;

	public FileuploadDao getFileuploadDao() {
		return fileuploadDao;
	}

	public void setFileuploadDao(FileuploadDao fileuploadDao) {
		this.fileuploadDao = fileuploadDao;
	}

	@Override
	public void saveFileinfo(Fileinfo fileinfo) {
		// TODO Auto-generated method stub
		fileuploadDao.saveFileinfo(fileinfo);
		
	}

	@Override
	public List<Fileinfo> findFileinfoByCid(Integer cid) {
		
		// TODO Auto-generated method stub
		return fileuploadDao.findFileinfoByCid(cid);
	}
	
}
